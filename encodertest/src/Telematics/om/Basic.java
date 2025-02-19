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

public class Basic extends Object {
	public Basic() {
	}

	private Position position;

	private Double speed;

	private Long direction;

	private List<MilElement> mils;

	private Double fuel;

	private EngineStatus engineStatus;

	private KeyStatus keyStatus;

	private Long distanceToEmpty;

	private Long odometer;

	private TimeStamp timeStamp;

	private UsageMode usageMode;

	private EngineBlockedStatus engineBlockedStatus;

	public Position getPosition() {
		
		return this.position;
	}
	
	public Double getSpeed() {
		
		return this.speed;
	}
	
	public Long getDirection() {
		
		return this.direction;
	}
	
	public List<MilElement> getMils() {
		
		return this.mils;
	}
	
	public Double getFuel() {
		
		return this.fuel;
	}
	
	public EngineStatus getEngineStatus() {
		
		return this.engineStatus;
	}
	
	public KeyStatus getKeyStatus() {
		
		return this.keyStatus;
	}
	
	public Long getDistanceToEmpty() {
		
		return this.distanceToEmpty;
	}
	
	public Long getOdometer() {
		
		return this.odometer;
	}
	
	public TimeStamp getTimeStamp() {
		
		return this.timeStamp;
	}
	
	public UsageMode getUsageMode() {
		
		return this.usageMode;
	}
	
	public EngineBlockedStatus getEngineBlockedStatus() {
		
		return this.engineBlockedStatus;
	}
	
	public void setPosition(Position position) {
		
		this.position = position;
	}

	public void setSpeed(Double speed) {
		
		this.speed = speed;
	}

	public void setDirection(Long direction) {
		
		this.direction = direction;
	}

	public void setMils(List<MilElement> mils) {
		
		this.mils = mils;
	}

	public void setFuel(Double fuel) {
		
		this.fuel = fuel;
	}

	public void setEngineStatus(EngineStatus engineStatus) {
		
		this.engineStatus = engineStatus;
	}

	public void setKeyStatus(KeyStatus keyStatus) {
		
		this.keyStatus = keyStatus;
	}

	public void setDistanceToEmpty(Long distanceToEmpty) {
		
		this.distanceToEmpty = distanceToEmpty;
	}

	public void setOdometer(Long odometer) {
		
		this.odometer = odometer;
	}

	public void setTimeStamp(TimeStamp timeStamp) {
		
		this.timeStamp = timeStamp;
	}

	public void setUsageMode(UsageMode usageMode) {
		
		this.usageMode = usageMode;
	}

	public void setEngineBlockedStatus(EngineBlockedStatus engineBlockedStatus) {
		
		this.engineBlockedStatus = engineBlockedStatus;
	}

	@Override
	public boolean equals(Object anObject) {
		if (this == anObject) return true;
		if ((anObject == null) || (anObject.getClass() != this.getClass())) return false;

		Basic comparator = (Basic)anObject;

		if ((this.getPosition() != comparator.getPosition()) && ((this.getPosition() == null) || (! this.getPosition().equals(comparator.getPosition())))) return false;
		if ((this.getSpeed() != comparator.getSpeed()) && ((this.getSpeed() == null) || (! this.getSpeed().equals(comparator.getSpeed())))) return false;
		if ((this.getDirection() != comparator.getDirection()) && ((this.getDirection() == null) || (! this.getDirection().equals(comparator.getDirection())))) return false;
		if ((this.getMils() != comparator.getMils()) && ((this.getMils() == null) || (! this.getMils().equals(comparator.getMils())))) return false;
		if ((this.getFuel() != comparator.getFuel()) && ((this.getFuel() == null) || (! this.getFuel().equals(comparator.getFuel())))) return false;
		if ((this.getEngineStatus() != comparator.getEngineStatus()) && ((this.getEngineStatus() == null) || (! this.getEngineStatus().equals(comparator.getEngineStatus())))) return false;
		if ((this.getKeyStatus() != comparator.getKeyStatus()) && ((this.getKeyStatus() == null) || (! this.getKeyStatus().equals(comparator.getKeyStatus())))) return false;
		if ((this.getDistanceToEmpty() != comparator.getDistanceToEmpty()) && ((this.getDistanceToEmpty() == null) || (! this.getDistanceToEmpty().equals(comparator.getDistanceToEmpty())))) return false;
		if ((this.getOdometer() != comparator.getOdometer()) && ((this.getOdometer() == null) || (! this.getOdometer().equals(comparator.getOdometer())))) return false;
		if ((this.getTimeStamp() != comparator.getTimeStamp()) && ((this.getTimeStamp() == null) || (! this.getTimeStamp().equals(comparator.getTimeStamp())))) return false;
		if ((this.getUsageMode() != comparator.getUsageMode()) && ((this.getUsageMode() == null) || (! this.getUsageMode().equals(comparator.getUsageMode())))) return false;
		if ((this.getEngineBlockedStatus() != comparator.getEngineBlockedStatus()) && ((this.getEngineBlockedStatus() == null) || (! this.getEngineBlockedStatus().equals(comparator.getEngineBlockedStatus())))) return false;
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 277;

		hash = 6841 * hash + (null == this.getPosition() ? 0 : this.getPosition().hashCode());
		hash = 2713 * hash + (null == this.getSpeed() ? 0 : this.getSpeed().hashCode());
		hash = 6221 * hash + (null == this.getDirection() ? 0 : this.getDirection().hashCode());
		hash = 5479 * hash + (null == this.getMils() ? 0 : this.getMils().hashCode());
		hash = 1307 * hash + (null == this.getFuel() ? 0 : this.getFuel().hashCode());
		hash = 6089 * hash + (null == this.getEngineStatus() ? 0 : this.getEngineStatus().hashCode());
		hash = 7789 * hash + (null == this.getKeyStatus() ? 0 : this.getKeyStatus().hashCode());
		hash = 4091 * hash + (null == this.getDistanceToEmpty() ? 0 : this.getDistanceToEmpty().hashCode());
		hash = 4349 * hash + (null == this.getOdometer() ? 0 : this.getOdometer().hashCode());
		hash = 6599 * hash + (null == this.getTimeStamp() ? 0 : this.getTimeStamp().hashCode());
		hash = 1663 * hash + (null == this.getUsageMode() ? 0 : this.getUsageMode().hashCode());
		hash = 7103 * hash + (null == this.getEngineBlockedStatus() ? 0 : this.getEngineBlockedStatus().hashCode());
		return hash;
	}

}
