function fileSelect(e) {  
    e = e || window.event;  
       
    var files = e.target.files;  //FileList Objects      
    var ireg = /image\/.*/i,  
        p = document.getElementById('xxs');  
           
    var ul = document.getElementById('Errors');  
    for(var i = 0, f; f = files[i]; i++) {  
        if(!f.type.match(ireg)) {  
            //设置错误信息  
            var li = document.createElement('li');  
            li.innerHTML = '<li>' + f.name +'不是图片文件.</li>';  
               
            ul.appendChild(li);  
               
            continue;  
        }  
           
        var reader = new FileReader();  
           
        reader.onload = (function(file) {  
            return function(e) {  
                var span = document.createElement('span');  
                var img = new Image;  
                img.alt=file.name;  
                img.onload = function() {  
                    console.log(img.height); // image is loaded; sizes are available  
                };  
  
                img.src=this.result;  
                span.innerHTML = '<img class="thumb" src="'+ this.result +'" alt="'+ file.name +'" />';  
                   
                p.insertBefore(span, null);  
            };  
        })(f);  
        //读取文件内容  
        reader.readAsDataURL(f);  
    }  
}  
       
if(window.File && window.FileList && window.FileReader && window.Blob) {  
    document.getElementById('up').addEventListener('change', fileSelect, false);  
} else {  
    document.write('您的浏览器不支持File Api');  
} 