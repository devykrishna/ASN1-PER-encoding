/*  
 *   This file was generated by openASN.1 - an open source ASN.1 toolkit for java
 *
 *   openASN.1 is Copyright (C) 2007 Clayton Hoss, Marc Weyland
 *
 *   openASN.1 is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU Lesser General Public License as 
 *   published by the Free Software Foundation, either version 3 of 
 *   the License, or (at your option) any later version.
 *
 *   openASN.1 is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *   GNU Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public License
 *   along with openASN.1. If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package Telematics.om;

import java.util.List;

public class TripStart extends Object {
	public TripStart() {
	}

	private Type type;

	private String startTime;

	private Position startPosition;

	private Long odometer;

	private Customer customer;

	private String enterpriseName;

	private List<Driver> driver;

	public Type getType() {
		
		return this.type;
	}
	
	public String getStartTime() {
		
		return this.startTime;
	}
	
	public Position getStartPosition() {
		
		return this.startPosition;
	}
	
	public Long getOdometer() {
		
		return this.odometer;
	}
	
	public Customer getCustomer() {
		
		return this.customer;
	}
	
	public String getEnterpriseName() {
		
		return this.enterpriseName;
	}
	
	public List<Driver> getDriver() {
		
		return this.driver;
	}
	
	public void setType(Type type) {
		
		this.type = type;
	}

	public void setStartTime(String startTime) {
		
		this.startTime = startTime;
	}

	public void setStartPosition(Position startPosition) {
		
		this.startPosition = startPosition;
	}

	public void setOdometer(Long odometer) {
		
		this.odometer = odometer;
	}

	public void setCustomer(Customer customer) {
		
		this.customer = customer;
	}

	public void setEnterpriseName(String enterpriseName) {
		
		this.enterpriseName = enterpriseName;
	}

	public void setDriver(List<Driver> driver) {
		
		this.driver = driver;
	}

	@Override
	public boolean equals(Object anObject) {
		if (this == anObject) return true;
		if ((anObject == null) || (anObject.getClass() != this.getClass())) return false;

		TripStart comparator = (TripStart)anObject;

		if ((this.getType() != comparator.getType()) && ((this.getType() == null) || (! this.getType().equals(comparator.getType())))) return false;
		if ((this.getStartTime() != comparator.getStartTime()) && ((this.getStartTime() == null) || (! this.getStartTime().equals(comparator.getStartTime())))) return false;
		if ((this.getStartPosition() != comparator.getStartPosition()) && ((this.getStartPosition() == null) || (! this.getStartPosition().equals(comparator.getStartPosition())))) return false;
		if ((this.getOdometer() != comparator.getOdometer()) && ((this.getOdometer() == null) || (! this.getOdometer().equals(comparator.getOdometer())))) return false;
		if ((this.getCustomer() != comparator.getCustomer()) && ((this.getCustomer() == null) || (! this.getCustomer().equals(comparator.getCustomer())))) return false;
		if ((this.getEnterpriseName() != comparator.getEnterpriseName()) && ((this.getEnterpriseName() == null) || (! this.getEnterpriseName().equals(comparator.getEnterpriseName())))) return false;
		if ((this.getDriver() != comparator.getDriver()) && ((this.getDriver() == null) || (! this.getDriver().equals(comparator.getDriver())))) return false;
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 1279;

		hash = 6871 * hash + (null == this.getType() ? 0 : this.getType().hashCode());
		hash = 6829 * hash + (null == this.getStartTime() ? 0 : this.getStartTime().hashCode());
		hash = 4637 * hash + (null == this.getStartPosition() ? 0 : this.getStartPosition().hashCode());
		hash = 4871 * hash + (null == this.getOdometer() ? 0 : this.getOdometer().hashCode());
		hash = 1321 * hash + (null == this.getCustomer() ? 0 : this.getCustomer().hashCode());
		hash = 773 * hash + (null == this.getEnterpriseName() ? 0 : this.getEnterpriseName().hashCode());
		hash = 4139 * hash + (null == this.getDriver() ? 0 : this.getDriver().hashCode());
		return hash;
	}

}
