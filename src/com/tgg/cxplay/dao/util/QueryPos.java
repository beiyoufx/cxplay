package com.tgg.cxplay.dao.util;

import org.hibernate.Query;

public class QueryPos {
	
	public static QueryPos getInstance(Query query) {
		return new QueryPos(query);
	}
	
	public <T> void add(T t) {
		_query.setParameter(_pos++, t);
	}
	
	private QueryPos(Query query) {
		_query = query;
	}

	private Query _query;
	private int _pos;
}
