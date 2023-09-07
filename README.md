# Camunda-Springboot

camunda-leave: Mysql database with leave-management.bpmn diagram and LeaveBalanceCheck JavaDelegate.
Process flow: 3 users to create in camunda.demo,manager,hr.
To start a process first check the leave balance then it moved to manager approval and its approved by manager then moved to hr approval. Its approved by hr the task is completed
Approve process: tick approve check box then click complete.


leave-camunda: H2 Database with leave-management.bpmn diagram and LeaveBalanceCheck JavaDelegate,config,controller,model.
Process flow: same as camunda-leave.
Post call: Check leave balance, Start camunda process, Complete camunda process-not working.
