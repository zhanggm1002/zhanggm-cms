<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form>
	<div class="form-group row">
		<label for="inputEmail3" class="col-sm-2 col-form-label">文章标题</label>
		<div class="col-sm-5">
			<input type="email" class="form-control" id="inputEmail3">
		</div>
	</div>
	<div class="form-group row">
		<label for="inputPassword3" class="col-sm-2 col-form-label">文章图片</label>
		<div class="col-sm-5">
			<div class="input-prepend">
				<div class="imgDive">
					<img src="/public/img/upload.jpg" class="img-rounded" width="80px;" id="viewImg">
					<div style="display: none;" id="imageuploadDiv" name="imageuploadDiv">
						<input type="file" id="fileName" name="fileName" onchange=""><br> 
						<input type="hidden" id="picture" name="picture" value="">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="form-group row">
		<label for="inputPassword3" class="col-sm-2 col-form-label">所属频道</label>
		<div class="col-sm-5">
			<select class="form-control" id="exampleFormControlSelect1">
				<option>请选择频道</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
			</select>
		</div>
	</div>

	<div class="form-group row">
		<label for="inputPassword3" class="col-sm-2 col-form-label">所属分类</label>
		<div class="col-sm-5">
			<select class="form-control" id="exampleFormControlSelect1">
				<option>请选择分类</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
			</select>
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-2">文章内容</div>
		<div class="col-sm-10">
			<div class="form-check">
				<textarea rows="3" cols=""></textarea>
			</div>
		</div>
	</div>
	<button type="button" class="btn btn-primary mb-2" onclick="save();">保存</button>
	<button type="button" class="btn btn-primary mb-2">保存并提交审核</button>
</form>
<script type="text/javascript">
	$(".imgDive").mouseover(function () {
		$(this).find("#imageuploadDiv").css("display","block");
	});
	$(".imgDive").mouseleave(function () {
	    $(this).find("#imageuploadDiv").css("display","none");
	});
	function save(){
		openPage("/article/articles");
	}
</script>