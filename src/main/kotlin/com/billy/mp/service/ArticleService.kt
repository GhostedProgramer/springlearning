//package com.billy.mp.service
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
//import com.baomidou.mybatisplus.core.metadata.IPage
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page
//import com.billy.mp.mapper.ArticleDao
//import com.billy.mp.model.Article
//import org.slf4j.Logger
//import org.slf4j.LoggerFactory
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.stereotype.Service
//
//@Service
//class ArticleService(
//    @Autowired val articleDao: ArticleDao
//) {
//
//    private val logger: Logger = LoggerFactory.getLogger(ArticleService::class.java)
//
//    /**
//     * 1.新增 , insert方法
//     * */
//    fun save(article: Article): Boolean {
//        return articleDao.insert(article) > 0
//    }
//
//    /**
//     * 2.通过QueryWrapper查询数量
//     * */
//    fun selectArticleCount(): Int {
//        return articleDao.selectCount(QueryWrapper<Article>().eq("title", "title"))
//    }
//
//    /**
//     * 3.通过selectMaps查询list<Map<String, Object>>
//     * */
//    fun selectArticleMaps(): List<Map<String, Any>> {
//        return articleDao.selectMaps(QueryWrapper<Article>().eq("title", "test"))
//    }
//
//    /**
//     * 4.通过QueryWrapper查询list<Object>
//     * */
//    fun selectObjects(): List<Any> {
//        return articleDao.selectObjs(QueryWrapper<Article>().eq("title", "title"))
//    }
//
//    /**
//     * 5.分页查询,笔者个人还是比较喜欢使用pagehelper来分页，毕竟比较简单
//     * */
//    fun selectPage(): IPage<Article> {
//        val queryWrapper = QueryWrapper<Article>().eq("title", "test")
//        val count = articleDao.selectCount(queryWrapper)
//        val page = Page<Article>(1L, 2L, count.toLong())
//        val list = articleDao.selectPage(page, queryWrapper)
//        logger.info("返回数据:${list.records}")
//        logger.info("总条数:${list.total},当前页码:${list.current},总页码:${list.pages},每页显示条数:${list.size}")
//        logger.info("返回的数据:${page.records}")
//        return list
//    }
//
//    /**
//     * 6，删除，根据articleId来删除
//     * */
//    fun delete(articleId: Long): Boolean {
//        return articleDao.deleteById(articleId) > 0
//    }
//
//    /**
//     * 7，删除，根据QueryWrapper删除
//     */
//    fun deleteByQueryWrapper(): Boolean {
//        return articleDao.delete(QueryWrapper<Article>().eq("title", "测试")) > 0
//    }
//
//    /**
//     * 8, 批量删除，把多个id存放到list中，再批量删除，其实很少会用到
//     */
//    fun deleteBatchIds(articleIdList: List<Long>): Boolean {
//        return articleDao.deleteBatchIds(articleIdList) > 0
//    }
//
//    /**
//     * 9，修改  封装方法中做了非空校验，如果该字段为null,则不进行更新
//     */
//    fun updateById(article: Article): Boolean {
//        return articleDao.updateById(article) > 0
//    }
//}