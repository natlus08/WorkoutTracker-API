/**
 * 
 */
package com.workouttracker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author hameedu sultan
 *
 */
@Entity
@Table(name="workout_active")
public class ActiveWorkout {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="active_workout_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="workout_id")
	private Workout workout;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	//@JsonFormat(pattern = "yyyy-mm-dd")
	private Date startDate;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "start_time")
	//@JsonFormat(pattern = "HH:mm:ss")
	private Date startTime;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	//@JsonFormat(pattern = "yyyy-mm-dd")
	private Date endDate;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "end_time")
	//@JsonFormat(pattern = "HH:mm:ss")
	private Date endTime;
	
	private String comment;
	
	private boolean status;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}	

}
