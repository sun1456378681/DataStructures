package com.paogu.template.course;

/**
 * 模板会有一个或多个未实现方法，而且这几个未实现方法有固定的执行效率
 *
 * @author eric
 * @since 2020/11/20 10:07
 */
public abstract class NetworkCourse {

    protected final void createCourse() {

        // 发布预习资料
        this.postPreResource();

        // 制作课件PPT
        this.createPPT();

        // 直播授课
        this.liveVideo();

        // 提交课堂笔记
        this.postNote();

        // 提交源代码
        this.postResource();
    }

    abstract void checkHomework();

    /**
     * 钩子方法：实现流程的微调
     *
     * @return
     */
    protected boolean needHomework() {
        return false;
    }

    final void postResource() {
        System.out.println("提交源代码");
    }

    final void postNote() {
        System.out.println("提交课件和笔记");
    }

    final void liveVideo() {
        System.out.println("直播授课");
    }

    final void createPPT() {
        System.out.println("创建备课PPT");
    }

    final void postPreResource() {
        System.out.println("发布预习资料");
    }
}
