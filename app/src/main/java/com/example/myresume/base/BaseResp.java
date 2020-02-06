package com.example.myresume.base;


public class BaseResp<Object> {

    /**
     * resultcode : 200
     * reason : Success
     * result : {"data":[{"id":"1001","title":"糖醋小排","tags":"浙菜;热菜;儿童;酸甜;快手菜","imtro":"糖醋小排，我估计爱吃的人太多了，要想做好这道菜，关键就是调料汁的配置，老抽不能放的太多，那样颜色太重， 不好看，调料汁调好后，最好尝一下，每个人的口味都会不同的，可以适当微调一下哈！","ingredients":"肋排,500g","burden":"葱,适量;白芝麻,适量;盐,3g;生粉,45g;料酒,30ml;鸡蛋,1个;葱,1小段;姜,3片;老抽,7ml;醋,30ml;白糖,20g;番茄酱,15ml;生抽,15ml;生粉,7g;姜,适量","albums":["http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/t/1/1001_253951.jpg"],"steps":[{"img":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/10/1001_40ec58177e146191.jpg","step":"1.排骨剁小块，用清水反复清洗，去掉血水"},{"img":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/10/1001_034906d012e61fcc.jpg","step":"2.排骨放入容器中，放入腌料，搅拌均匀，腌制5分钟"},{"img":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/10/1001_b04cddaea2a1a604.jpg","step":"3.锅中放适量油，烧至5成热，倒入排骨，炸至冒青烟时捞出，关火，等油温降至五成热时，开火，再次放入排骨，中火炸至焦黄、熟透捞出"},{"img":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/10/1001_56b92264df500f01.jpg","step":"4.锅中留少许底油，放入葱花、姜片爆香"},{"img":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/cookbook/s/10/1001_d78c57536a08dc4b.jpg","step":"5.放入适量炸好的排骨，倒入调料汁，煮至汤汁浓稠时，关火，撒入葱花、白芝麻点缀即可"}]}],"totalNum":1,"pn":0,"rn":1}
     * error_code : 0
     */

    private int resultcode;
    private String reason;
    private Object result;
    private int error_code;

    public int getResultcode() {
        return resultcode;
    }

    public void setResultcode(int resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

}
