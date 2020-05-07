package com.dao;

public class Review {

String rate,comment;

public String getRate() {
	return rate;
}

public void setRate(String rate) {
	this.rate = rate;
}

public String getComment() {
	return comment;
}

public void setComment(String comment) {
	this.comment = comment;
}

@Override
public String toString() {
	return "Review [rate=" + rate + ", comment=" + comment + "]";
}



}
