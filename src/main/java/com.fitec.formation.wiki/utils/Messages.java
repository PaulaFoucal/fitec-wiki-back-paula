package com.fitec.formation.wiki.utils;

public interface Messages {
	
//	String DATE_ERROR_MESSAGE = "% % % % % ERROR: Incorrect date format! % % % % %";
	String USER_SUCCESS_MESSAGE = "% % % % % SUCCESS: User mapped! % % % % %";
	String ARTICLE_SUCCESS_MESSAGE = "% % % % % SUCCESS: Article mapped! % % % % %";
	String COMMENT_SUCCESS_MESSAGE = "% % % % % SUCCESS: Comment mapped! % % % % %";

	String ARTICLE_ERROR_NULL = "% % % % % ERROR: The given article is null! % % % % %";
	String ARTICLE_ERROR_NULL_DONT_EXIST = "% % % % % ERROR: The given article is null or does not exist in DB! % % % % %";
	String ARTICLE_ERROR_DONT_EXIST = "% % % % % ERROR: The given article does not exist in DB! % % % % %";

	String ARTICLE_SUCCESS_ADDED = "% % % % % SUCCESS: Article added! % % % % %";
	String ARTICLE_SUCCESS_UPDATED = "% % % % % SUCCESS: Article updated! % % % % %";
	String ARTICLE_SUCCESS_DELETED = "% % % % % SUCCESS: Article deleted! % % % % %";

    String COMMENT_ERROR_NULL = "% % % % % ERROR: The given comment is null! % % % % %";
    String COMMENT_ERROR_NULL_DONT_EXIST = "% % % % % ERROR: The given comment is null or does not exist in DB! % % % % %";
    String COMMENT_ERROR_DONT_EXIST = "% % % % % ERROR: The given comment does not exist in DB! % % % % %";

    String COMMENT_SUCCESS_ADDED = "% % % % % SUCCESS: Comment added! % % % % %";
    String COMMENT_SUCCESS_UPDATED = "% % % % % SUCCESS: Comment updated! % % % % %";
    String COMMENT_SUCCESS_DELETED = "% % % % % SUCCESS: Comment deleted! % % % % %";

    String USER_ERROR_NULL = "% % % % % ERROR: The given comment is null! % % % % %";
    String USER_ERROR_NULL_DONT_EXIST = "% % % % % ERROR: The given comment is null or does not exist in DB! % % % % %";
    String USER_ERROR_DONT_EXIST = "% % % % % ERROR: The given comment does not exist in DB! % % % % %";

    String USER_SUCCESS_ADDED = "% % % % % SUCCESS: Comment added! % % % % %";
    String USER_SUCCESS_UPDATED = "% % % % % SUCCESS: Comment updated! % % % % %";
    String USER_SUCCESS_DELETED = "% % % % % SUCCESS: Comment deleted! % % % % %";

    String USER_ERROR_SET_STATUS = "% % % % % ERROR: Status not set! % % % % %";

    String USER_SUCCESS_SET_STATUS = "% % % % % SUCCESS: Status set! % % % % %";

}
