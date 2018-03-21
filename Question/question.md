------------------------------------------解决问题文档(FAQ)---------------------------------------  

Q:  
	git 提交:warning: LF will be replaced by CRLF  

A:  
	$ git config --global core.autocrlf false  //禁用自动转换      
	$ git add . 