package com.ajh.aijihui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

@Controller
@RequestMapping("goods")
@CrossOrigin(origins = {"*","null"})
public class uploadController {

	@ResponseBody
	@RequestMapping("upload")
	public String upload(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
		System.out.println("执行upload");
		request.setCharacterEncoding("UTF-8");
		String url = "";
		if(!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			String path = null;
			String type = null;
			type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
			if (type != null) {
				if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
					// 项目在容器中实际发布运行的根路径
					String realPath = "E:/ajhImage";
					// 自定义的文件名称
					String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
					// 设置存放图片文件的路径
					path = realPath + "/uploads/" + trueFileName;
					file.transferTo(new File(path));
					url = path;
				}else {
					return "error";
				}
			}else {
				return "error";
			}
		}else {
			return "error";
		}
		return url;
	}

	@RequestMapping("preview")
	@ResponseBody
	public String preview(String imageUrl){
		ByteArrayOutputStream outputStream = null;
		try {
			BufferedImage bufferedImage = ImageIO.read(new File(imageUrl));
			outputStream = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, "png", outputStream);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		// 返回Base64编码过的字节数组字符串
		return "data:image/png;base64," + encoder.encode(outputStream.toByteArray());
	}
}