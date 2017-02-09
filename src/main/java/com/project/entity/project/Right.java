package com.project.entity.project;

import com.project.entity.TbRight;

public class Right extends TbRight {
	//是否已有权限
	private int ischecked;

	public int getIschecked() {
		return ischecked;
	}

	public void setIschecked(int ischecked) {
		this.ischecked = ischecked;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Right){
			if(((Right)obj).getRightId() == this.getRightId()){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
}
