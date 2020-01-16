package com.lvqibin.oa.sys.model;



import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Process {
	
	protected String id;
	protected String deploymentId;
	protected String name;
	protected String resourceName;
	protected  String key;
	protected String diagramresourcename;
	protected int version;
}
