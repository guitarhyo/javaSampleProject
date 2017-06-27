package com.ztest.batch;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class CommonJob extends QuartzJobBean {

	private Boolean isRun;
	private CommonTask commonTask;


	protected void executeInternal(final JobExecutionContext context) throws JobExecutionException {
		try {
			if (this.isRun) {
				this.commonTask.run();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @return the isRun
	 */
	public Boolean getIsRun() {
		return isRun;
	}

	/**
	 * @param isRun the isRun to set
	 */
	public void setIsRun(Boolean isRun) {
		this.isRun = isRun;
	}

	/**
	 * @return the commonTask
	 */
	public CommonTask getCommonTask() {
		return commonTask;
	}

	/**
	 * @param commonTask the commonTask to set
	 */
	public void setCommonTask(CommonTask commonTask) {
		this.commonTask = commonTask;
	}

	

}
