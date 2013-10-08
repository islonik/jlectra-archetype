package com.jlectra.web.request;

import com.jlectra.core.url.Url;

/**
 * Created with IntelliJ IDEA.
 * User: anton
 * Date: 9/25/13
 * Time: 8:39 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Request {
    public <T> T getParameter(String parameter, Class<T> type);
}
