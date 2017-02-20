package com.project.entity.project;

import com.project.entity.TbRole;

public class Role extends TbRole{
	
	private int ischecked;

	public int getIschecked() {
		return ischecked;
	}

	public void setIschecked(int ischecked) {
		this.ischecked = ischecked;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Role){
			if(
				((Role)obj).getRoleId()
				.equals(this.getRoleId())){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		
		return super.getRoleId()+super.getRoleName().hashCode();
	}
}
