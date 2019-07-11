package com.spring.quartz.schedule.job;

import com.spring.quartz.book.entity.Book;
import com.spring.quartz.book.service.BookService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ScheduleJob2 extends QuartzJobBean {

    private BookService bookService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            System.out.println("------------------任务开始Job2------------------");
            Book book = bookService.get();
            System.out.println(book.toString());
            System.out.println("------------------任务结束Job2------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
