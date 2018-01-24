/*
 * Title:        CloudSim Toolkit
 * Description:  CloudSim (Cloud Simulation) Toolkit for Modeling and Simulation of Clouds
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2009-2012, The University of Melbourne, Australia
 */

package org.cloudbus.cloudsim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cloudbus.cloudsim.core.CloudSim;

/**
 * VmAllocationPolicySimple is an VmAllocationPolicy that chooses, as the host for a VM, the host
 * with less PEs in use. It is therefore a Worst Fit policy, allocating VMs into the 
 * host with most available PE.
 * 
 * @author Rodrigo N. Calheiros
 * @author Anton Beloglazov
 * @since CloudSim Toolkit 1.0
 */
public class VmAllocationPolicySimple extends VmAllocationPolicy {

	/** The map between each VM and its allocated host.
         * The map key is a VM UID and the value is the allocated host for that VM. */
	private Map<String, Host> vmTable;

	/** The map between each VM and the number of Pes used. 
         * The map key is a VM UID and the value is the number of used Pes for that VM. */
	private Map<String, Integer> usedPes;

	/** The number of free Pes for each host from {@link #getHostList() }. */
	private List<Integer> freePes;

	/**
	 * Creates a new VmAllocationPolicySimple object.
	 * 
	 * @param list the list of hosts
	 * @pre $none
	 * @post $none
	 */
	public VmAllocationPolicySimple(List<? extends Host> list) {
		super(list);

		setFreePes(new ArrayList<Integer>());
		for (Host host : getHostList()) {
			getFreePes().add(host.getNumberOfPes());

		}

		setVmTable(new HashMap<String, Host>());
		setUsedPes(new HashMap<String, Integer>());
	}

	/**
	 * Allocates the host with less PEs in use for a given VM.
	 * 
	 * @param vm {@inheritDoc}
	 * @return {@inheritDoc}
	 * @pre $none
	 * @post $none
	 */
	@Override
	public boolean allocateHostForVm(Vm vm) {
		int requiredPes = vm.getNumberOfPes();
		boolean result = false;
		int tries = 0;
		List<Integer> freePesTmp = new ArrayList<Integer>();
		for (Integer freePes : getFreePes()) {
			freePesTmp.add(freePes);
		}

		/*if (!getVmTable().containsKey(vm.getUid())) { // if this vm was not created
			do {// we still trying until we find a host or until we try all of them
				int moreFree = Integer.MIN_VALUE;
				int idx = -1;

				// we want the host with less pes in use
				for (int i = 0; i < freePesTmp.size(); i++) {
					if (freePesTmp.get(i) > moreFree) {
						moreFree = freePesTmp.get(i);
						idx = i;
					}
				}

				Host host = getHostList().get(idx);
				result = host.vmCreate(vm);

				if (result) { // if vm were succesfully created in the host
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(idx, getFreePes().get(idx) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(idx, Integer.MIN_VALUE);
				}
				tries++;
			} while (!result && tries < getFreePes().size());

		}*/

		List<Host> hostList=getHostList();
		if (vm.getId()>=0 && vm.getId()<10)
		{
			do{
				Host host=hostList.get(0);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=10 && vm.getId()<20)
		{
			do{
				Host host=hostList.get(1);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=20 && vm.getId()<30)
		{
			do{
				Host host=hostList.get(2);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=30 && vm.getId()<40)
		{
			do{
				Host host=hostList.get(3);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=50 && vm.getId()<60)
		{
			do{
				Host host=hostList.get(5);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=60 && vm.getId()<70)
		{
			do{
				Host host=hostList.get(6);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=70 && vm.getId()<80)
		{
			do{
				Host host=hostList.get(7);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=80 && vm.getId()<90)
		{
			do{
				Host host=hostList.get(8);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=90 && vm.getId()<100)
		{
			do{
				Host host=hostList.get(9);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=100 && vm.getId()<110)
		{
			do{
				Host host=hostList.get(10);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=110 && vm.getId()<120)
		{
			do{
				Host host=hostList.get(11);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=120 && vm.getId()<130)
		{
			do{
				Host host=hostList.get(12);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=130 && vm.getId()<140)
		{
			do{
				Host host=hostList.get(13);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=140 && vm.getId()<150)
		{
			do{
				Host host=hostList.get(14);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=150 && vm.getId()<160)
		{
			do{
				Host host=hostList.get(15);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=160 && vm.getId()<170)
		{
			do{
				Host host=hostList.get(16);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=170 && vm.getId()<180)
		{
			do{
				Host host=hostList.get(17);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=180 && vm.getId()<190)
		{
			do{
				Host host=hostList.get(18);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=190 && vm.getId()<200)
		{
			do{
				Host host=hostList.get(19);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		/*
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}
		else if (vm.getId()>=40 && vm.getId()<50)
		{
			do{
				Host host=hostList.get(4);
				result=host.vmCreate(vm);
				if (result) { // if vm were succesfully created in the host
					System.out.println("Host id is:"+host.getId());
					getVmTable().put(vm.getUid(), host);
					getUsedPes().put(vm.getUid(), requiredPes);
					getFreePes().set(host.getId(), getFreePes().get(host.getId()) - requiredPes);
					result = true;
					break;
				} else {
					freePesTmp.set(host.getId(), Integer.MIN_VALUE);
				}
				tries++;
			}while (!result && tries < getFreePes().size());
			
		}*/
		return result;
	}

	@Override
	public void deallocateHostForVm(Vm vm) {
		System.out.println("*************");
		System.out.println(vm.getUid());
		System.out.println("*************");
		Host host = getVmTable().remove(vm.getUid());
		int idx = getHostList().indexOf(host);
		int pes = getUsedPes().remove(vm.getUid());
		if (host != null) {
			host.vmDestroy(vm);
			getFreePes().set(idx, getFreePes().get(idx) + pes);
		}
	}

	@Override
	public Host getHost(Vm vm) {
		return getVmTable().get(vm.getUid());
	}

	@Override
	public Host getHost(int vmId, int userId) {
		return getVmTable().get(Vm.getUid(userId, vmId));
	}

	/**
	 * Gets the vm table.
	 * 
	 * @return the vm table
	 */
	public Map<String, Host> getVmTable() {
		return vmTable;
	}

	/**
	 * Sets the vm table.
	 * 
	 * @param vmTable the vm table
	 */
	protected void setVmTable(Map<String, Host> vmTable) {
		this.vmTable = vmTable;
	}

	/**
	 * Gets the used pes.
	 * 
	 * @return the used pes
	 */
	protected Map<String, Integer> getUsedPes() {
		return usedPes;
	}

	/**
	 * Sets the used pes.
	 * 
	 * @param usedPes the used pes
	 */
	protected void setUsedPes(Map<String, Integer> usedPes) {
		this.usedPes = usedPes;
	}

	/**
	 * Gets the free pes.
	 * 
	 * @return the free pes
	 */
	protected List<Integer> getFreePes() {
		return freePes;
	}

	/**
	 * Sets the free pes.
	 * 
	 * @param freePes the new free pes
	 */
	protected void setFreePes(List<Integer> freePes) {
		this.freePes = freePes;
	}

	@Override
	public List<Map<String, Object>> optimizeAllocation(List<? extends Vm> vmList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean allocateHostForVm(Vm vm, Host host) {
		if (host.vmCreate(vm)) { // if vm has been succesfully created in the host
			getVmTable().put(vm.getUid(), host);

			int requiredPes = vm.getNumberOfPes();
			int idx = getHostList().indexOf(host);
			getUsedPes().put(vm.getUid(), requiredPes);
			getFreePes().set(idx, getFreePes().get(idx) - requiredPes);

			Log.formatLine(
					"%.2f: VM #" + vm.getId() + " has been allocated to the host #" + host.getId(),
					CloudSim.clock());
			return true;
		}

		return false;
	}
}
