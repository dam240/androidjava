package com.cd.admin.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cd.admin.model.book;
import com.cd.admin.service.adim_ser;
import com.opensymphony.xwork2.ActionSupport;
@Component("book")
@Scope("prototype")
public class book_up extends ActionSupport {

	private int id;
public void setId(int id) {
		this.id = id;
	}

List <File> image_w;
List <File> image_b;
private List<String>  image_wFileName;
private List<String>  image_bFileName;
private String bname;

private String price;
private String disprice;

private String discount;
private String author;
private String press;
private int cid;
public void setBname(String bname) {
	this.bname = bname;
}

public void setPrice(String price) {
	this.price = price;
}

public void setDisprice(String disprice) {
	this.disprice = disprice;
}

public void setDiscount(String discount) {
	this.discount = discount;
}

public void setAuthor(String author) {
	this.author = author;
}

public void setPress(String press) {
	this.press = press;
}

public void setCid(int cid) {
	this.cid = cid;
}

public void setPublishtime(String publishtime) {
	this.publishtime = publishtime;
}

public void setEdition(String edition) {
	this.edition = edition;
}

public void setPageNum(String pageNum) {
	this.pageNum = pageNum;
}

public void setWordNum(String wordNum) {
	this.wordNum = wordNum;
}

public void setPrinttime(String printtime) {
	this.printtime = printtime;
}

public void setBooksize(String booksize) {
	this.booksize = booksize;
}

public void setPaper(String paper) {
	this.paper = paper;
}

private String publishtime;
private String edition;
private String pageNum;
private String wordNum;
private String printtime;
private String booksize;
private String paper;


public List<File> getImage_w() {
	return image_w;
}

public List<File> getImage_b() {
	return image_b;
}

public List<String> getImage_wFileName() {
	return image_wFileName;
}

public List<String> getImage_bFileName() {
	return image_bFileName;
}

public List<String> getFileContentType() {
	return fileContentType;
}

public void setImage_w(List<File> image_w) {
	this.image_w = image_w;
}

public void setImage_b(List<File> image_b) {
	this.image_b = image_b;
}

public void setImage_wFileName(List<String> image_wFileName) {
	this.image_wFileName = image_wFileName;
}

public void setImage_bFileName(List<String> image_bFileName) {
	this.image_bFileName = image_bFileName;
}

public void setFileContentType(List<String> fileContentType) {
	this.fileContentType = fileContentType;
}

private List<String> fileContentType;


private adim_ser adm; 
	@Resource
	public void setAdm(adim_ser adm) {
	this.adm = adm;
}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String name1=null; 
		String name2=null; 
		String imgpath = "book_img/";
        for (int i = 0; i < image_w.size(); ++i) {
            InputStream is = new FileInputStream(image_w.get(i));
        
            String path = ServletActionContext.getServletContext().getRealPath("/");
            System.out.println(path);
        //    String root = "D:\\";
                
           
            File destFile = new File(path+imgpath, this.getImage_wFileName().get(i));
         
            OutputStream os = new FileOutputStream(destFile);
            name1=imgpath+this.getImage_wFileName().get(i);
            byte[] buffer = new byte[400];

            int length = 0;

            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            
           
            is.close();

            os.close();
        }
        System.out.println(name1);
        
          
        
        for (int i = 0; i < image_b.size(); ++i) {
            InputStream is = new FileInputStream(image_b.get(i));
          
            String path = ServletActionContext.getServletContext().getRealPath("/");
            System.out.println(path);
        //    String root = "D:\\";
                
           
            File destFile = new File(path+imgpath, this.getImage_bFileName().get(i));
         
            OutputStream os = new FileOutputStream(destFile);
            name2=imgpath+this.getImage_bFileName().get(i);
            byte[] buffer = new byte[400];

            int length = 0;

            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            
           
            is.close();

            os.close();
        }
        
        
        
        book k=new book();
        k.setPage(pageNum);
        k.setA_id(cid);
        k.setBook_name(bname);
        k.setTu_A(name1);
        k.setTu_B(name2);
        k.setChu_tiem(publishtime);
        k.setYi_tiem(printtime);
        k.setK_b(booksize);
        k.setZi_zhang(paper);
        k.setZhi_shu(wordNum);
        k.setBan_one(edition);
        k.setChu(press);
        k.setZuo(this.author);
        k.setZhe(discount);
        k.setD_ji(disprice);
        k.setNow_ji(price);
        adm.save_book(k);
        
        
        
		return super.execute();
	}

	
	
 public String book_up(){
	 
	 
	  book k=new book();
	  k.setBook_id(id);
      k.setPage(pageNum);
      k.setA_id(cid);
      k.setBook_name(bname);
  
      k.setChu_tiem(publishtime);
      k.setYi_tiem(printtime);
      k.setK_b(booksize);
      k.setZi_zhang(paper);
      k.setZhi_shu(wordNum);
      k.setBan_one(edition);
      k.setChu(press);
      k.setZuo(this.author);
      k.setZhe(discount);
      k.setD_ji(disprice);
      k.setNow_ji(price);
      
	  adm.go_up(k);
	 
	 return SUCCESS;
 }
	
	
	
}
