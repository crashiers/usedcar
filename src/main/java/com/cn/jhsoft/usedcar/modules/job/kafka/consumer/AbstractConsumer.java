package com.cn.jhsoft.usedcar.modules.job.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * @author chenyi
 * @date 18/5/2018.
 */
public abstract class AbstractConsumer<T> {

	/**
	 * kafka消费监控
	 * @param record
	 */
	public  abstract void listen(ConsumerRecord<?, ?> record);

	/**
	 * 消费记录,向mysql表做操作
	 * @param t
	 */
	public abstract void updateOrInsert(T t);

	protected String rowKeyRegex(Long productId,Integer deltaId,String mid){
		return "^"+productId+"\\+\\d*\\+"+deltaId+"\\+"+mid+"$";
	}

	protected   long remainingTime(){
		return Long.MAX_VALUE-System.currentTimeMillis();
	}

}
