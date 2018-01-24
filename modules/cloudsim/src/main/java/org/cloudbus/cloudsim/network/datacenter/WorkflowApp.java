
package org.cloudbus.cloudsim.network.datacenter;

import java.util.List;

import org.cloudbus.cloudsim.UtilizationModel;
import org.cloudbus.cloudsim.UtilizationModelFull;
import org.cloudbus.cloudsim.core.CloudSim;


public class WorkflowApp extends AppCloudlet {

	public WorkflowApp(int type, int appID, double deadline, int numbervm, int userId) {
		super(type, appID, deadline, numbervm, userId);
		exeTime = 100;
		this.numbervm = 5;
	}

	@Override
	public void createCloudletList(List<Integer> vmIdList) {
		long fileSize = NetworkConstants.FILE_SIZE;
		long outputSize = NetworkConstants.OUTPUT_SIZE;
		int memory = 500;
		UtilizationModel utilizationModel = new UtilizationModelFull();
		
		// Task 1
		NetworkCloudlet c1 = new NetworkCloudlet(
				NetworkConstants.currentCloudletId,
				0,
				1,
				fileSize,
				outputSize,
				memory,
				utilizationModel,
				utilizationModel,
				utilizationModel);
		c1.numStage = 2;
		NetworkConstants.currentCloudletId++;
		c1.setUserId(userId);
		c1.submittime = CloudSim.clock();
		c1.currStagenum = -1;
		c1.setVmId(3);

		// first stage: big computation
		c1.stages.add(new TaskStage(NetworkConstants.EXECUTION, 0, 1000 * 1, 0, memory, 3, c1.getCloudletId()));
		c1.stages.add(new TaskStage(NetworkConstants.WAIT_SEND, 600000, 0, 1, memory, 4, c1.getCloudletId() + 1));
		c1.stages.add(new TaskStage(NetworkConstants.WAIT_SEND, 700000, 0, 1, memory, 0, c1.getCloudletId() + 2));
		c1.stages.add(new TaskStage(NetworkConstants.WAIT_SEND, 800000, 0, 1, memory, 2, c1.getCloudletId() + 3));		
		clist.add(c1);
		
		// Task 2
		NetworkCloudlet c2 = new NetworkCloudlet(
				NetworkConstants.currentCloudletId,
				0,
				1,
				fileSize,
				outputSize,
				memory,
				utilizationModel, 	
				utilizationModel,
				utilizationModel);
		c2.numStage = 2;
		NetworkConstants.currentCloudletId++;
		c2.setUserId(userId);
		c2.submittime = CloudSim.clock();
		c2.currStagenum = -1;
		c2.setVmId(4);

		// first stage: big computation

		c2.stages.add(new TaskStage(NetworkConstants.WAIT_RECV, 600000, 0, 0, memory, 3, c1.getCloudletId()));
		
		c2.stages.add(new TaskStage(NetworkConstants.EXECUTION, 0, 1000 * 1, 0, memory, 4, c2.getCloudletId()));
		
		c2.stages.add(new TaskStage(NetworkConstants.WAIT_SEND, 600000, 0, 1, memory, 6, c2.getCloudletId() + 3));
		
		clist.add(c2);

		// Task 3
		NetworkCloudlet c3 = new NetworkCloudlet(
				NetworkConstants.currentCloudletId,
				0,
				1,
				fileSize,
				outputSize,
				memory,
				utilizationModel,
				utilizationModel,
				utilizationModel);
		c3.numStage = 2;
		NetworkConstants.currentCloudletId++;
		c3.setUserId(userId);
		c3.submittime = CloudSim.clock();
		c3.currStagenum = -1;
		c3.setVmId(0);

		// first stage: big computation
		c3.stages.add(new TaskStage(NetworkConstants.WAIT_RECV, 700000, 0, 0, memory, 3, c1.getCloudletId()));
		c3.stages.add(new TaskStage(NetworkConstants.EXECUTION, 0, 1000 * 1, 1, memory, 0, c3.getCloudletId()));
		c3.stages.add(new TaskStage(NetworkConstants.WAIT_SEND, 700000, 0, 1, memory, 6, c3.getCloudletId() + 2));
		clist.add(c3);
		
		//Task 4
		NetworkCloudlet c4 = new NetworkCloudlet(
				NetworkConstants.currentCloudletId,
				0,
				1,
				fileSize,
				outputSize,
				memory,
				utilizationModel,
				utilizationModel,
				utilizationModel);
		c4.numStage = 2;
		NetworkConstants.currentCloudletId++;
		c4.setUserId(userId);
		c4.submittime = CloudSim.clock();
		c4.currStagenum = -1;
		c4.setVmId(2);

		// first stage: big computation
		c4.stages.add(new TaskStage(NetworkConstants.WAIT_RECV, 800000, 0, 0, memory, 3, c1.getCloudletId()));
		c4.stages.add(new TaskStage(NetworkConstants.EXECUTION, 0, 1000 * 1, 1, memory, 2, c4.getCloudletId()));
		c4.stages.add(new TaskStage(NetworkConstants.WAIT_SEND, 800000, 0, 1, memory, 6, c4.getCloudletId() + 1));
		clist.add(c4);
		
		//Task 5
		NetworkCloudlet c5 = new NetworkCloudlet(
				NetworkConstants.currentCloudletId,
				0,
				1,
				fileSize,
				outputSize,
				memory,
				utilizationModel,
				utilizationModel,
				utilizationModel);
		c5.numStage = 2;
		NetworkConstants.currentCloudletId++;
		c5.setUserId(userId);
		c5.submittime = CloudSim.clock();
		c5.currStagenum = -1;
		c5.setVmId(6);

		// first stage: big computation
		c5.stages.add(new TaskStage(NetworkConstants.WAIT_RECV, 600000, 0, 0, memory, 4, c2.getCloudletId()));
		c5.stages.add(new TaskStage(NetworkConstants.WAIT_RECV, 700000, 0, 0, memory, 0, c3.getCloudletId()));
		c5.stages.add(new TaskStage(NetworkConstants.WAIT_RECV, 800000, 0, 0, memory, 2, c4.getCloudletId()));
		c5.stages.add(new TaskStage(NetworkConstants.EXECUTION, 0, 1000 * 1, 1, memory, 6, c5.getCloudletId()));
		clist.add(c5);

	}
}
