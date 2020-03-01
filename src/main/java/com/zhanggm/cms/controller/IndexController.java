package com.zhanggm.cms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.zhanggm.cms.pojo.Article;
import com.zhanggm.cms.pojo.Category;
import com.zhanggm.cms.pojo.Channel;
import com.zhanggm.cms.pojo.Comment;
import com.zhanggm.cms.pojo.Link;
import com.zhanggm.cms.pojo.Slide;
import com.zhanggm.cms.pojo.User;
import com.zhanggm.cms.service.ArticleService;
import com.zhanggm.cms.service.CommentService;
import com.zhanggm.cms.service.LinkService;
import com.zhanggm.cms.service.SlideService;
import com.zhanggm.cms.service.UserService;

@Controller
public class IndexController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private SlideService slideService;
	@Autowired
	private UserService userService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private LinkService linkService;
	/** 定义线程池 **/
	private ExecutorService executorService = Executors.newFixedThreadPool(5);

	@Autowired
	private RedisTemplate redisTemplate;
	
	/**
	 * @Title: index   
	 * @Description: 首页   
	 * @param: @param model
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@RequestMapping("/")
	public String index(Model model) {
		hot(model, 1);
		return "index";
	}
	/**
	 * @Title: hot   
	 * @Description: 热门分页   
	 * @param: @param model
	 * @param: @param pageNum
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@RequestMapping("/hot/{pageNum}.html")
	public String hot(Model model,@PathVariable Integer pageNum) {
		/** 计数器  **/
		CountDownLatch countDownLatch = new CountDownLatch(2);
		/** 频道 **/
		List<Channel> channelList = new ArrayList<Channel>();
		/** 新线程查询数据  **/
		executorService.execute(()->{
			List<Channel> list = articleService.getChannelAll();
			channelList.addAll(list);
			/** 计数减1  **/
			countDownLatch.countDown();
		});
		
		model.addAttribute("channelList", channelList);
		/** 焦点图 **/
		List<Slide> slideList = new ArrayList<>();
		/** 新线程查询数据  **/
		executorService.execute(()->{
			List<Slide> list = slideService.getAll();
			slideList.addAll(list);
			/** 计数减1  **/
			countDownLatch.countDown();
		});
		model.addAttribute("slideList", slideList);
		/** 热点文章 **/
		PageInfo<Article> pageInfo = articleService.getHotList(pageNum,4);
		model.addAttribute("pageInfo", pageInfo);
		/** 最新文章 **/
		List<Article> newArticleList = articleService.getNewList(6);
		model.addAttribute("newArticleList", newArticleList);
		/** 友情链接 **/
		List<Link> linkList = linkService.getLinkListAll();
		model.addAttribute("linkList", linkList);
		/** 最新图片 **/
		List<Article> newPicList = articleService.getNewPicList(6);
		model.addAttribute("newPicList", newPicList);
		/** 等待线程都执行完成  **/
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "index";
	}
	
	/**
	 * @Title: channel   
	 * @Description: 频道页   
	 * @param: @param model
	 * @param: @param channelId
	 * @param: @param cateId
	 * @param: @param pageNum
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@RequestMapping("/{channelId}/{cateId}/{pageNum}.html")
	public String channel(Model model,@PathVariable Integer channelId,@PathVariable Integer cateId,@PathVariable Integer pageNum) {
		List<Channel> channelList = articleService.getChannelAll();
		List<Slide> slideList = slideService.getAll();
		PageInfo<Article> pageInfo = articleService.getList(channelId,cateId,pageNum,6);
		List<Category> cateList = articleService.getCateListByChannelId(channelId);
		Channel channel = articleService.getChannelByChannelId(channelId);
		List<Article> newArticleList = articleService.getNewList(6);
		model.addAttribute("channelList", channelList);
		model.addAttribute("cateList", cateList);
		model.addAttribute("slideList", slideList);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("channel", channel);
		model.addAttribute("newArticleList", newArticleList);
		/** 友情链接 **/
		List<Link> linkList = linkService.getLinkListAll();
		model.addAttribute("linkList", linkList);
		return "index";
	}
	/**
	 * @Title: articleDetail   
	 * @Description: 文章详情页  
	 * @param: @param id
	 * @param: @param model
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/article/detail/{id}.html")
	public String articleDetail(@PathVariable Integer id,@RequestParam(value="pageNum",defaultValue="1") Integer pageNum,Model model) {
		/** 定义缓存的Key **/
		String cacheKey = "article:"+id;
		/** 查文章是否在缓存 **/
		Article article = (Article)redisTemplate.opsForValue().get(cacheKey);
		/** 如果没有，查询数据，同时缓存到redis **/
		if(article==null) {
			article = articleService.getById(id);
			redisTemplate.opsForValue().set(cacheKey, article);
			System.out.println("缓存完成");
		}else {
			System.out.println("缓存的数据");
		}
		
		User user = userService.getById(article.getUser_id());
		article.setNickname(user.getNickname());
		model.addAttribute("article", article);
		/** 查询相关文章 **/
		List<Article> relArticelList = articleService.getRelArticelList(article.getChannel_id(), article.getCategory_id(), article.getId(), 3);
		model.addAttribute("relArticelList", relArticelList);
		/** 设置文章点击量，若点击量大于20成为热点文章 **/
		articleService.setHitsAndHot(id);
		/** 评论列表 **/
		PageInfo<Comment> commentPageInfo = commentService.getPageInfo(article.getId(), pageNum, 10);
		model.addAttribute("pageInfo", commentPageInfo);
		
		/** 处理图片 **/
		if(article.getType()==1) {
			String content = article.getContent();
			Gson gson = new Gson();
			List<HashMap<String,Object>> fromJson = gson.fromJson(content,ArrayList.class);
			model.addAttribute("pics", fromJson);
		}
		return "article-detail";
	}
	
}
