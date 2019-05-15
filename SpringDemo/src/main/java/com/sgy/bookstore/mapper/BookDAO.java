package com.sgy.bookstore.mapper;

import com.sgy.bookstore.entities.Book;

import java.util.List;

public interface BookDAO {

    /**
     * 获取所有图书
     * @return 所有图书
     */
    public List<Book> getAllBooks();

    /**
     * 根据图书编号获取图书对象
     * @param id 图书编号
     * @return 图书对象
     */
    public Book getBookById(int id);

    /**
     * 添加图书
     * @param book 图书对象
     * @return 受影响行数
     */
    public int add(Book book);

    /**
     * 根据图书编号删除图书
     * @param id 图书编号
     * @return 受影响行数
     */
    public int delete(int id);

    /**
     * 更新图书信息
     * @param book 图书对象
     * @return 受影响行数
     */
    public int update(Book book);
}
