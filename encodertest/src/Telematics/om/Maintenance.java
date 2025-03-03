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

public class Maintenance extends Object {
	public Maintenance() {
	}

	private BatteryStatus mainBatteryStatus;

	private Double tyreStatusDriver;

	private Double tyreStatusPassenger;

	private Double tyreStatusDriverRear;

	private Double tyreStatusPassengerRear;

	private WarningLevel tyrePreWarningDriver;

	private WarningLevel tyrePreWarningPassenger;

	private WarningLevel tyrePreWarningDriverRear;

	private WarningLevel tyrePreWarningPassengerRear;

	private Double engineHrsToService;

	private Double distanceToService;

	private Double daysToService;

	private WarningStatus serviceWarningStatus;

	private ServiceWarningTrigger serviceWarningTrigger;

	private BrakeFluidLevelStatus brakeFluidLevelStatus;

	private WasherFluidLevelStatus washerFluidLevelStatus;

	private TimeStamp timeStamp;

	public BatteryStatus getMainBatteryStatus() {
		
		return this.mainBatteryStatus;
	}
	
	public Double getTyreStatusDriver() {
		
		return this.tyreStatusDriver;
	}
	
	public Double getTyreStatusPassenger() {
		
		return this.tyreStatusPassenger;
	}
	
	public Double getTyreStatusDriverRear() {
		
		return this.tyreStatusDriverRear;
	}
	
	public Double getTyreStatusPassengerRear() {
		
		return this.tyreStatusPassengerRear;
	}
	
	public WarningLevel getTyrePreWarningDriver() {
		
		return this.tyrePreWarningDriver;
	}
	
	public WarningLevel getTyrePreWarningPassenger() {
		
		return this.tyrePreWarningPassenger;
	}
	
	public WarningLevel getTyrePreWarningDriverRear() {
		
		return this.tyrePreWarningDriverRear;
	}
	
	public WarningLevel getTyrePreWarningPassengerRear() {
		
		return this.tyrePreWarningPassengerRear;
	}
	
	public Double getEngineHrsToService() {
		
		return this.engineHrsToService;
	}
	
	public Double getDistanceToService() {
		
		return this.distanceToService;
	}
	
	public Double getDaysToService() {
		
		return this.daysToService;
	}
	
	public WarningStatus getServiceWarningStatus() {
		
		return this.serviceWarningStatus;
	}
	
	public ServiceWarningTrigger getServiceWarningTrigger() {
		
		return this.serviceWarningTrigger;
	}
	
	public BrakeFluidLevelStatus getBrakeFluidLevelStatus() {
		
		return this.brakeFluidLevelStatus;
	}
	
	public WasherFluidLevelStatus getWasherFluidLevelStatus() {
		
		return this.washerFluidLevelStatus;
	}
	
	public TimeStamp getTimeStamp() {
		
		return this.timeStamp;
	}
	
	public void setMainBatteryStatus(BatteryStatus mainBatteryStatus) {
		
		this.mainBatteryStatus = mainBatteryStatus;
	}

	public void setTyreStatusDriver(Double tyreStatusDriver) {
		
		this.tyreStatusDriver = tyreStatusDriver;
	}

	public void setTyreStatusPassenger(Double tyreStatusPassenger) {
		
		this.tyreStatusPassenger = tyreStatusPassenger;
	}

	public void setTyreStatusDriverRear(Double tyreStatusDriverRear) {
		
		this.tyreStatusDriverRear = tyreStatusDriverRear;
	}

	public void setTyreStatusPassengerRear(Double tyreStatusPassengerRear) {
		
		this.tyreStatusPassengerRear = tyreStatusPassengerRear;
	}

	public void setTyrePreWarningDriver(WarningLevel tyrePreWarningDriver) {
		
		this.tyrePreWarningDriver = tyrePreWarningDriver;
	}

	public void setTyrePreWarningPassenger(WarningLevel tyrePreWarningPassenger) {
		
		this.tyrePreWarningPassenger = tyrePreWarningPassenger;
	}

	public void setTyrePreWarningDriverRear(WarningLevel tyrePreWarningDriverRear) {
		
		this.tyrePreWarningDriverRear = tyrePreWarningDriverRear;
	}

	public void setTyrePreWarningPassengerRear(WarningLevel tyrePreWarningPassengerRear) {
		
		this.tyrePreWarningPassengerRear = tyrePreWarningPassengerRear;
	}

	public void setEngineHrsToService(Double engineHrsToService) {
		
		this.engineHrsToService = engineHrsToService;
	}

	public void setDistanceToService(Double distanceToService) {
		
		this.distanceToService = distanceToService;
	}

	public void setDaysToService(Double daysToService) {
		
		this.daysToService = daysToService;
	}

	public void setServiceWarningStatus(WarningStatus serviceWarningStatus) {
		
		this.serviceWarningStatus = serviceWarningStatus;
	}

	public void setServiceWarningTrigger(ServiceWarningTrigger serviceWarningTrigger) {
		
		this.serviceWarningTrigger = serviceWarningTrigger;
	}

	public void setBrakeFluidLevelStatus(BrakeFluidLevelStatus brakeFluidLevelStatus) {
		
		this.brakeFluidLevelStatus = brakeFluidLevelStatus;
	}

	public void setWasherFluidLevelStatus(WasherFluidLevelStatus washerFluidLevelStatus) {
		
		this.washerFluidLevelStatus = washerFluidLevelStatus;
	}

	public void setTimeStamp(TimeStamp timeStamp) {
		
		this.timeStamp = timeStamp;
	}

	@Override
	public boolean equals(Object anObject) {
		if (this == anObject) return true;
		if ((anObject == null) || (anObject.getClass() != this.getClass())) return false;

		Maintenance comparator = (Maintenance)anObject;

		if ((this.getMainBatteryStatus() != comparator.getMainBatteryStatus()) && ((this.getMainBatteryStatus() == null) || (! this.getMainBatteryStatus().equals(comparator.getMainBatteryStatus())))) return false;
		if ((this.getTyreStatusDriver() != comparator.getTyreStatusDriver()) && ((this.getTyreStatusDriver() == null) || (! this.getTyreStatusDriver().equals(comparator.getTyreStatusDriver())))) return false;
		if ((this.getTyreStatusPassenger() != comparator.getTyreStatusPassenger()) && ((this.getTyreStatusPassenger() == null) || (! this.getTyreStatusPassenger().equals(comparator.getTyreStatusPassenger())))) return false;
		if ((this.getTyreStatusDriverRear() != comparator.getTyreStatusDriverRear()) && ((this.getTyreStatusDriverRear() == null) || (! this.getTyreStatusDriverRear().equals(comparator.getTyreStatusDriverRear())))) return false;
		if ((this.getTyreStatusPassengerRear() != comparator.getTyreStatusPassengerRear()) && ((this.getTyreStatusPassengerRear() == null) || (! this.getTyreStatusPassengerRear().equals(comparator.getTyreStatusPassengerRear())))) return false;
		if ((this.getTyrePreWarningDriver() != comparator.getTyrePreWarningDriver()) && ((this.getTyrePreWarningDriver() == null) || (! this.getTyrePreWarningDriver().equals(comparator.getTyrePreWarningDriver())))) return false;
		if ((this.getTyrePreWarningPassenger() != comparator.getTyrePreWarningPassenger()) && ((this.getTyrePreWarningPassenger() == null) || (! this.getTyrePreWarningPassenger().equals(comparator.getTyrePreWarningPassenger())))) return false;
		if ((this.getTyrePreWarningDriverRear() != comparator.getTyrePreWarningDriverRear()) && ((this.getTyrePreWarningDriverRear() == null) || (! this.getTyrePreWarningDriverRear().equals(comparator.getTyrePreWarningDriverRear())))) return false;
		if ((this.getTyrePreWarningPassengerRear() != comparator.getTyrePreWarningPassengerRear()) && ((this.getTyrePreWarningPassengerRear() == null) || (! this.getTyrePreWarningPassengerRear().equals(comparator.getTyrePreWarningPassengerRear())))) return false;
		if ((this.getEngineHrsToService() != comparator.getEngineHrsToService()) && ((this.getEngineHrsToService() == null) || (! this.getEngineHrsToService().equals(comparator.getEngineHrsToService())))) return false;
		if ((this.getDistanceToService() != comparator.getDistanceToService()) && ((this.getDistanceToService() == null) || (! this.getDistanceToService().equals(comparator.getDistanceToService())))) return false;
		if ((this.getDaysToService() != comparator.getDaysToService()) && ((this.getDaysToService() == null) || (! this.getDaysToService().equals(comparator.getDaysToService())))) return false;
		if ((this.getServiceWarningStatus() != comparator.getServiceWarningStatus()) && ((this.getServiceWarningStatus() == null) || (! this.getServiceWarningStatus().equals(comparator.getServiceWarningStatus())))) return false;
		if ((this.getServiceWarningTrigger() != comparator.getServiceWarningTrigger()) && ((this.getServiceWarningTrigger() == null) || (! this.getServiceWarningTrigger().equals(comparator.getServiceWarningTrigger())))) return false;
		if ((this.getBrakeFluidLevelStatus() != comparator.getBrakeFluidLevelStatus()) && ((this.getBrakeFluidLevelStatus() == null) || (! this.getBrakeFluidLevelStatus().equals(comparator.getBrakeFluidLevelStatus())))) return false;
		if ((this.getWasherFluidLevelStatus() != comparator.getWasherFluidLevelStatus()) && ((this.getWasherFluidLevelStatus() == null) || (! this.getWasherFluidLevelStatus().equals(comparator.getWasherFluidLevelStatus())))) return false;
		if ((this.getTimeStamp() != comparator.getTimeStamp()) && ((this.getTimeStamp() == null) || (! this.getTimeStamp().equals(comparator.getTimeStamp())))) return false;
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 2521;

		hash = 6481 * hash + (null == this.getMainBatteryStatus() ? 0 : this.getMainBatteryStatus().hashCode());
		hash = 4967 * hash + (null == this.getTyreStatusDriver() ? 0 : this.getTyreStatusDriver().hashCode());
		hash = 907 * hash + (null == this.getTyreStatusPassenger() ? 0 : this.getTyreStatusPassenger().hashCode());
		hash = 2273 * hash + (null == this.getTyreStatusDriverRear() ? 0 : this.getTyreStatusDriverRear().hashCode());
		hash = 4079 * hash + (null == this.getTyreStatusPassengerRear() ? 0 : this.getTyreStatusPassengerRear().hashCode());
		hash = 349 * hash + (null == this.getTyrePreWarningDriver() ? 0 : this.getTyrePreWarningDriver().hashCode());
		hash = 6121 * hash + (null == this.getTyrePreWarningPassenger() ? 0 : this.getTyrePreWarningPassenger().hashCode());
		hash = 2003 * hash + (null == this.getTyrePreWarningDriverRear() ? 0 : this.getTyrePreWarningDriverRear().hashCode());
		hash = 2909 * hash + (null == this.getTyrePreWarningPassengerRear() ? 0 : this.getTyrePreWarningPassengerRear().hashCode());
		hash = 5483 * hash + (null == this.getEngineHrsToService() ? 0 : this.getEngineHrsToService().hashCode());
		hash = 7549 * hash + (null == this.getDistanceToService() ? 0 : this.getDistanceToService().hashCode());
		hash = 2903 * hash + (null == this.getDaysToService() ? 0 : this.getDaysToService().hashCode());
		hash = 907 * hash + (null == this.getServiceWarningStatus() ? 0 : this.getServiceWarningStatus().hashCode());
		hash = 271 * hash + (null == this.getServiceWarningTrigger() ? 0 : this.getServiceWarningTrigger().hashCode());
		hash = 6011 * hash + (null == this.getBrakeFluidLevelStatus() ? 0 : this.getBrakeFluidLevelStatus().hashCode());
		hash = 6883 * hash + (null == this.getWasherFluidLevelStatus() ? 0 : this.getWasherFluidLevelStatus().hashCode());
		hash = 5399 * hash + (null == this.getTimeStamp() ? 0 : this.getTimeStamp().hashCode());
		return hash;
	}

}
