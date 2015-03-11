package com.dream.cms.common;

import java.util.ArrayList;
import java.util.List;

public final class JsonQuery {
	private List<Condition> conditions;
	private Relation relation;
	private List<OrderBy> orderBy;
	private long start;
	private int limit;

	public List<Condition> getConditions() {
		if (conditions == null) {
			conditions = new ArrayList<Condition>();
		}
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public Relation getRelation() {
		if (relation == null) {
			relation = Relation.AND;
		}
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

	public List<OrderBy> getOrderBy() {
		if (orderBy == null) {
			orderBy = new ArrayList<OrderBy>();
		}
		return orderBy;
	}

	public void setOrderBy(List<OrderBy> orderBy) {
		this.orderBy = orderBy;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public enum OrderSequence {
		ASC, DESC
	}

	public enum Relation {
		AND, OR
	}

	public static class OrderBy {
		private String name;
		private OrderSequence order;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public OrderSequence getOrder() {
			if (order == null) {
				order = OrderSequence.ASC;
			}
			return order;
		}

		public void setOrder(OrderSequence order) {
			this.order = order;
		}

		public String toString() {
			return "name:" + this.getName() + "order:" + this.getOrder();

		}
	}

	public static class Condition {
		private String name; // 鏁版嵁搴撳瓧娈靛悕绉帮紝鍙互甯﹁〃鍒悕锛屽r.rolename
		private String value; // 鍖归厤
		private String logic; // 鏋氫妇锛歔=,>,>=,<,<=,<>,LIKE,BETWEEN,IN,SQL]
		private String value2; // 褰搇ogic=BETWEEN鏃讹紝鍚庨潰閭ｄ釜鍊�
		private List<String> values; // 褰搇ogic=IN鏃讹紝鍚庨潰閭ｄ釜鍊�
		private String relation; // 褰撲娇鐢⊿QL鎷兼帴鏃讹紝姝ゅ�闇�疆涓哄瓧娈电殑鍓嶇疆鍏崇郴锛欰ND OR

		public Condition() {
		}

		public Condition(String name, String logic, String value) {
			super();
			this.name = name;
			this.value = value;
			this.logic = logic;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getLogic() {
			return logic;
		}

		public void setLogic(String logic) {
			this.logic = logic;
		}

		public String getValue2() {
			return value2;
		}

		public void setValue2(String value2) {
			this.value2 = value2;
		}

		public void setValues(List<String> values) {
			this.values = values;
		}

		public List<String> getValues() {
			return values;
		}

		public String getRelation() {
			return relation;
		}

		public void setRelation(String relation) {
			this.relation = relation;
		}

		public String toString() {
			StringBuffer ConditionString = new StringBuffer();
			ConditionString
					.append("Logic:" + this.getLogic() + "name:"
							+ this.getName() + "relation:" + this.getRelation()
							+ "value:" + this.getValue() + "value2:"
							+ this.getValue2());
			if (this.getValues() != null && this.getValues().size() > 0) {
				for (String str : this.getValues()) {
					ConditionString.append("values: " + str);
				}
			}

			return ConditionString.toString();
		}
	}

	@Override
	public String toString() {

		StringBuffer JsonQueryString = new StringBuffer();

		if (this.getConditions() != null && this.getConditions().size() > 0) {
			for (Condition condition : this.getConditions()) {
				JsonQueryString.append("conditions:" + condition.toString());
			}
		}
		JsonQueryString.append("relation:" + this.getRelation());

		if (this.getOrderBy() != null && this.getOrderBy().size() > 0) {
			for (OrderBy order : this.getOrderBy()) {
				JsonQueryString.append("order:" + order.toString());
			}
		}
		JsonQueryString.append("start:" + this.getStart());
		JsonQueryString.append("limit:" + this.getLimit());
		return JsonQueryString.toString();
	}
}
