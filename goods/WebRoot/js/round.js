function round(num,dec){ 
    var strNum = num + '';/*��Ҫת����С��ת�����ַ���*/
    var index = strNum.indexOf("."); /*��ȡС�����λ��*/
    if(index < 0) {
        return num;/*���û��С���㣬��ô�����������룬�����������*/
    }
    var n = strNum.length - index -1;/*��ȡ��ǰ��������С������λ��*/
    if(dec < n){ 
    	/*��С��������ƶ�Ҫ������λ��������Ҫ������С�����ֱ���������֣�ֻ���²���Ҫ�����Ĳ���ΪС��*/ 
        var e = Math.pow(10, dec);
        num = num * e;
        /*�����������룬ֻ������������*/
        num = Math.round(num);
        /*�ٰ�ԭ��С�����ֻ�ԭΪС��*/
        return num / e;
    } else { 
        return num;/*�����ǰС������λ�����ڻ�С��Ҫ������λ������ô���账��ֱ�ӷ���*/
    } 
} 

