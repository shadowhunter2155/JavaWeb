package service;

public class BMIService {
	public String getBMI(String height, String weight) {
		if (height == null || weight == null) {
			return "無參數或參數數量不正確";
			
		}
		double h = 0, w = 0;
		try {
			h = Double.parseDouble(height);
			w = Double.parseDouble(weight);
		} catch (Exception e) {
			return "請輸入正確數值資料";
		}
		if (h < 10 || h > 300 || w < 10 || w > 1000) {
			return"資料不正確, 超過合理範圍";
		}

		double bmi = w / Math.pow(h / 100, 2);
		String output = String.format("Height:%.1f Weight:%.1f BMI:%.2f", h, w, bmi);
		return output;
	}
}
