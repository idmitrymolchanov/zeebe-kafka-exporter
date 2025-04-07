package io.zeebe.exporters.kafka.zeebe;

//import io.camunda.zeebe.client.ZeebeClient;
//import io.camunda.zeebe.model.bpmn.Bpmn;
//import io.camunda.zeebe.model.bpmn.BpmnModelInstance;
//import io.camunda.zeebe.model.bpmn.instance.FlowElement;
//
//import java.io.File;
//
//public class BpmnModelFetcher {
//    private final ZeebeClient zeebeClient;
//
//    public BpmnModelFetcher(ZeebeClient zeebeClient) {
//        this.zeebeClient = zeebeClient;
//    }
//
//    public void mainsss() {
//        BpmnModelInstance modelInstance = Bpmn.readModelFromFile(new File("path/to/process.bpmn"));
//        FlowElement flowElement = modelInstance.getModelElementById("StartEvent_1");
//
//        if (flowElement != null) {
//            System.out.println("Element Name: " + flowElement.getName());
//        } else {
//            System.out.println("Element not found");
//        }
//    }
//}
