package tianqin.iedu.facatory;

public class NutritionFacts {
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;
	
	public static class Builder{
		private int servingSize;
		private int servings;
		private int calories;
		private int fat;
		private int sodium;
		private int carbohydrate;
		
		public Builder setServingSize(int servingSize) {
			this.servingSize = servingSize;
			return this;
		}
		public Builder setServings(int servings) {
			this.servings = servings;
			return this;
		}
		public Builder setCalories(int calories) {
			this.calories = calories;
			return this;
		}
		public Builder setFat(int fat) {
			this.fat = fat;
			return this;
		}
		public Builder setSodium(int sodium) {
			this.sodium = sodium;
			return this;
		}
		
		public Builder setCarbohydrate(int carbohydrate) {
			this.carbohydrate = carbohydrate;
			return this;
		}
		
		
		public NutritionFacts build() {
			return new NutritionFacts(this);
		}
		
	}
	
	//利用构建器，进行初始化
	public NutritionFacts(Builder builder) {
		super();
		this.servingSize = builder.servingSize;
		this.servings = builder.servings;
		this.calories = builder.calories;
		this.fat = builder.fat;
		this.sodium = builder.sodium;
		this.carbohydrate = builder.carbohydrate;
	}

	public int getServingSize() {
		return servingSize;
	}

	public int getServings() {
		return servings;
	}

	public int getCalories() {
		return calories;
	}

	public int getFat() {
		return fat;
	}

	public int getSodium() {
		return sodium;
	}

	public int getCarbohydrate() {
		return carbohydrate;
	}
	
	
	
}
