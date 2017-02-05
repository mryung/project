package com.myproject.message;

public class Pageable implements java.io.Serializable {
	private static final long serialVersionUID = 7728375179072013720L;
	/** 每页默认行数. */
	public static final int DEFAULT_ROWS = 10;
	/** 每页最大允许行数. */
	public static final int MAX_ROWS = 100;
	/** 页码. */
	private int page;
	/** 每页行数. */
	private int pagesize;
	/** 筛选 */
	//private List<Filter>filters;

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
//	public List<Filter> getFilters() {
//		return filters;
//	}
//	public void setFilters(List<Filter> filters) {
//		this.filters = filters;
//	}
//	public String toWhere(){
//		if(filters==null) return "";
//		List<String>list=new ArrayList<String>();
//		for(Filter filter : filters){
//			if("C".equals(filter.getFldtype())){
//				if("R".equals(filter.getFldbox())){
//					if(filter.getFldoneval()!=null && !"".equals(filter.getFldoneval())){
//						list.add(filter.getFldalias()+"='"+filter.getFldoneval()+"'");
//					}
//				}else if("T".equals(filter.getFldbox())){
//					if(!"".equals(filter.getFldoneval())){
//						list.add(filter.getFldalias()+" in ("+filter.getFldoneval()+")");
//					}
//				}else{
//					if(!"".equals(filter.getFldoneval())){
//						list.add(filter.getFldalias()+" like '%"+filter.getFldoneval()+"%'");
//					}
//				}
//			}else if("D".equals(filter.getFldtype())){
//				if(!"".equals(filter.getFldoneval())){
//					list.add(filter.getFldalias()+">=to_date('"+filter.getFldoneval()+" 00:00:00','yyyy-mm-dd hh24:mi:ss')");
//				}
//				if(!"".equals(filter.getFldtwoval())){
//					list.add(filter.getFldalias()+"<=to_date('"+filter.getFldtwoval()+" 23:59:59','yyyy-mm-dd hh24:mi:ss')");
//				}
//			}else if("T".equals(filter.getFldtype())){
//				if(!"".equals(filter.getFldoneval())){
//					list.add(filter.getFldalias()+">=to_date('"+filter.getFldoneval()+" :00','yyyy-mm-dd hh24:mi:ss')");
//				}
//				if(!"".equals(filter.getFldtwoval())){
//					list.add(filter.getFldalias()+"<=to_date('"+filter.getFldtwoval()+" :59','yyyy-mm-dd hh24:mi:ss')");
//				}
//			}else if("N".equals(filter.getFldtype())){
//				if("R".equals(filter.getFldbox())){
//					if(filter.getFldoneval()!=null && !"".equals(filter.getFldoneval())){
//						list.add(filter.getFldalias()+"="+filter.getFldoneval());
//					}
//				}else if("T".equals(filter.getFldbox())){
//					if(!"".equals(filter.getFldoneval())){
//						list.add(filter.getFldalias()+" in ("+filter.getFldoneval()+")");
//					}
//				}else{
//					if(!"".equals(filter.getFldoneval())){
//						list.add(filter.getFldalias()+">="+filter.getFldoneval());
//					}
//					if(!"".equals(filter.getFldtwoval())){
//						list.add(filter.getFldalias()+"<="+filter.getFldtwoval());
//					}	
//				}
//			}
//		}
//		if(list.isEmpty()) return "";
//		StringBuffer sb=new StringBuffer();
//		for(int i=0; i<list.size();i++){
//			if(i==0){
//				sb.append(list.get(i));
//			}else{
//				sb.append(" and ").append(list.get(i));
//			}
//		}
//		return sb.toString();
//	}
}