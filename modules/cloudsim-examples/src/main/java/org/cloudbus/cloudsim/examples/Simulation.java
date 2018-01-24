package org.cloudbus.cloudsim.examples;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.CloudletSchedulerTimeShared;
import org.cloudbus.cloudsim.Datacenter;
import org.cloudbus.cloudsim.DatacenterBroker;
import org.cloudbus.cloudsim.DatacenterCharacteristics;
import org.cloudbus.cloudsim.Host;
import org.cloudbus.cloudsim.Log;
import org.cloudbus.cloudsim.Pe;
import org.cloudbus.cloudsim.Storage;
import org.cloudbus.cloudsim.UtilizationModelFull;
import org.cloudbus.cloudsim.Vm;
import org.cloudbus.cloudsim.VmAllocationPolicySimple;
import org.cloudbus.cloudsim.VmSchedulerSpaceShared;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.lists.VmList;
import org.cloudbus.cloudsim.provisioners.BwProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.PeProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.RamProvisionerSimple;

/**
 * 
 */

/**
 * @author Susmit
 *
 */
public class Simulation 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int numUser=1;
		Calendar cal = Calendar.getInstance();
		boolean traceFlag=false;
		
		CloudSim.init(numUser, cal, traceFlag);
	
		Datacenter dc = CreateDataCenter();
		DatacenterBroker dcb = null;
		try {
			dcb = new DatacenterBroker("DatacenterBroker1");
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
		//4) Create Cloudlets
		
		List<Cloudlet> cloudletList = new ArrayList<Cloudlet>();
		//int cloudletId=0; 
		long cloudletLength=40000;
		int pesNumber=1;
		long cloudletFileSize= 300; 
		long cloudletOutputSize=400; 
		UtilizationModelFull fullUtilize = new UtilizationModelFull();
		
		for(int cloudletId=0; cloudletId <40; cloudletId++)
		{
			Cloudlet newCloudlet = new Cloudlet(cloudletId, cloudletLength, pesNumber, cloudletFileSize, cloudletOutputSize, 
					fullUtilize, fullUtilize, fullUtilize);
			newCloudlet.setUserId(dcb.getId());
			cloudletList.add(newCloudlet);
		}
		
		//5)Create VMs
		List<Vm> vmList = new ArrayList<Vm>();
		long disksize = 20000;
		int ram = 2000;
		int mips = 1000;
		int bandwidth = 1000;
		int vCPU = 1;
		String VMM = "XEN";
		
		
		
		for(int vmId = 0; vmId < 10; vmId++)
		{			
			Vm virtualmachine = new Vm(vmId, dcb.getId(), mips, vCPU, ram, bandwidth, disksize, VMM,
					new CloudletSchedulerTimeShared());
			vmList.add(virtualmachine);
		}
		 dcb.submitCloudletList(cloudletList);
		 dcb.submitVmList(vmList);
		 
		CloudSim.startSimulation();
		List<Cloudlet> finalCloudletExecutionResults = dcb.getCloudletReceivedList();
		CloudSim.stopSimulation();
		
		int cloudletNo=0;
		for(Cloudlet c : finalCloudletExecutionResults)
		{
			Log.printLine("Results of cloudlet No" + cloudletNo);
			Log.printLine("*********************");
			Log.printLine("ID:" +c.getCloudletId() + " VM:" + c.getVmId() + " status:" + c.getStatus());
			
			Log.printLine("*********************");
		}
	}
	
	private static Datacenter CreateDataCenter()
	{
		List<Pe> peList = new ArrayList<Pe>();
		
		PeProvisionerSimple pProvisioner = new PeProvisionerSimple(1000);
		
		Pe core1 = new Pe(0, pProvisioner);
		peList.add(core1);
		Pe core2 = new Pe(1, pProvisioner);
		peList.add(core2);
		Pe core3 = new Pe(2, pProvisioner);
		peList.add(core3);
		Pe core4 = new Pe(3, pProvisioner);
		peList.add(core4);
		
		List<Host> hostlist = new ArrayList<Host>();
		int ram = 8000;
		int bw = 8000;
		long storage = 100000;
		Host host1 = new Host(0, new RamProvisionerSimple(ram), new BwProvisionerSimple(bw), storage, 
				peList, new VmSchedulerSpaceShared(peList));
		hostlist.add(host1);
		Host host2 = new Host(1, new RamProvisionerSimple(ram), new BwProvisionerSimple(bw), storage, 
				peList, new VmSchedulerSpaceShared(peList));
		hostlist.add(host2);
		Host host4 = new Host(3, new RamProvisionerSimple(ram), new BwProvisionerSimple(bw), storage, 
				peList, new VmSchedulerSpaceShared(peList));
		hostlist.add(host4);
		Host host3 = new Host(2, new RamProvisionerSimple(ram), new BwProvisionerSimple(bw), storage, 
				peList, new VmSchedulerSpaceShared(peList));
		hostlist.add(host3);
		
		String architecture = "x86";
		String os = "Linux" ;
		String vmm = "XEN" ;
		double timeZone=5.0; 
		double ComputecostPerSec=3.0; 
		double costPerMem=1.0; 
		double costPerStorage=0.05;
		double costPerBw=0.10;
		
	
		DatacenterCharacteristics dcCharacteristics = new DatacenterCharacteristics(architecture, os, vmm, 
				hostlist, timeZone, ComputecostPerSec, costPerMem, costPerStorage, costPerBw);
		
		LinkedList<Storage> SanStorage = new LinkedList<Storage>();
		
		Datacenter dc = null;
		
		try 
		{
			dc = new Datacenter("Datacenter1", dcCharacteristics, new VmAllocationPolicySimple(hostlist), SanStorage, 1);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dc;
	}

}
