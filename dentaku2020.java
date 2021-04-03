package dentaku2020;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Dentaku2020 extends Application {

	TextField result;//結果の表示
	Button[] numbutton = new Button[12];
	Button[] calcbutton = new Button[5];
	Button clearbutton;
	int i = 0;
	String s;

	public void start (Stage stage) {
		//メインウィンドウの設定
		stage.setWidth(200);
		stage.setHeight(270);
		stage.setTitle("電卓");

		result = new TextField("");//結果の表示画面
		result.setPrefSize(200, 20);

		//数字ボタンの生成
		while(i < 10) {
			s = String.valueOf(i);
			numbutton[i] = new Button(s);
			i++;
		}
		numbutton[10] = new Button(".");
		numbutton[11] = new Button("+/-");
		//計算ボタンの生成
		calcbutton[0] = new Button("÷");
		calcbutton[1] = new Button("×");
		calcbutton[2] = new Button("-");
		calcbutton[3] = new Button("+");
		calcbutton[4] = new Button("=");
		clearbutton = new Button("c");
		//ボタンのサイズ指定
		numbutton[0].setPrefSize(100, 50);
		for(i = 1; i < 12; i++) {
			numbutton[i].setPrefSize(50, 50);
		};
		for(i = 0; i < 5; i++) {
			calcbutton[i].setPrefSize(50, 50);
		}
		clearbutton.setPrefSize(100, 50);

		//ボタンのイベントハンドラの登録
		clearbutton.setOnAction(event -> ClearButtonPressed());
		numbutton[0].setOnAction(event -> NumButtonPressed0());
		numbutton[1].setOnAction(event -> NumButtonPressed1());
		numbutton[2].setOnAction(event -> NumButtonPressed2());
		numbutton[3].setOnAction(event -> NumButtonPressed3());
		numbutton[4].setOnAction(event -> NumButtonPressed4());
		numbutton[5].setOnAction(event -> NumButtonPressed5());
		numbutton[6].setOnAction(event -> NumButtonPressed6());
		numbutton[7].setOnAction(event -> NumButtonPressed7());
		numbutton[8].setOnAction(event -> NumButtonPressed8());
		numbutton[9].setOnAction(event -> NumButtonPressed9());
		numbutton[10].setOnAction(event -> NumButtonPressed10());
		numbutton[11].setOnAction(event -> NumButtonPressed11());
		calcbutton[0].setOnAction(event -> CalcButtonPressed0());
		calcbutton[1].setOnAction(event -> CalcButtonPressed1());
		calcbutton[2].setOnAction(event -> CalcButtonPressed2());
		calcbutton[3].setOnAction(event -> CalcButtonPressed3());
		calcbutton[4].setOnAction(event -> CalcButtonPressed4());


		//ミドルサイズのキーの生成
		GridPane midPanel1 = new GridPane();
		GridPane.setConstraints(clearbutton,  0, 0);
		midPanel1.getChildren().addAll(clearbutton);

		GridPane midPanel2 = new GridPane();
		GridPane.setConstraints(numbutton[11],  0, 0);
		GridPane.setConstraints(calcbutton[0],  1, 0);
		midPanel2.getChildren().addAll(numbutton[11], calcbutton[0]);

		GridPane midPanel3 = new GridPane();
		GridPane.setConstraints(numbutton[7],  0, 0);
		GridPane.setConstraints(numbutton[8],  1, 0);
		midPanel3.getChildren().addAll(numbutton[7], numbutton[8]);

		GridPane midPanel4 = new GridPane();
		GridPane.setConstraints(numbutton[9],  0, 0);
		GridPane.setConstraints(calcbutton[1],  1, 0);
		midPanel4.getChildren().addAll(numbutton[9], calcbutton[1]);

		GridPane midPanel5 = new GridPane();
		GridPane.setConstraints(numbutton[4],  0, 0);
		GridPane.setConstraints(numbutton[5],  1, 0);
		midPanel5.getChildren().addAll(numbutton[4], numbutton[5]);

		GridPane midPanel6 = new GridPane();
		GridPane.setConstraints(numbutton[6],  0, 0);
		GridPane.setConstraints(calcbutton[2],  1, 0);
		midPanel6.getChildren().addAll(numbutton[6], calcbutton[2]);

		GridPane midPanel7 = new GridPane();
		GridPane.setConstraints(numbutton[1],  0, 0);
		GridPane.setConstraints(numbutton[2],  1, 0);
		midPanel7.getChildren().addAll(numbutton[1], numbutton[2]);

		GridPane midPanel8 = new GridPane();
		GridPane.setConstraints(numbutton[3],  0, 0);
		GridPane.setConstraints(calcbutton[3],  1, 0);
		midPanel8.getChildren().addAll(numbutton[3], calcbutton[3]);

		GridPane midPanel9 = new GridPane();
		GridPane.setConstraints(numbutton[0],  0, 0);
		midPanel9.getChildren().addAll(numbutton[0]);

		GridPane midPanel10 = new GridPane();
		GridPane.setConstraints(numbutton[10],  0, 0);
		GridPane.setConstraints(calcbutton[4],  1, 0);
		midPanel10.getChildren().addAll(numbutton[10], calcbutton[4]);

		//キーボードの配置の生成
		GridPane keyPanel = new GridPane();
		GridPane.setConstraints(midPanel1, 0, 0);
		GridPane.setConstraints(midPanel2, 1, 0);
		GridPane.setConstraints(midPanel3, 0, 1);
		GridPane.setConstraints(midPanel4, 1, 1);
		GridPane.setConstraints(midPanel5, 0, 2);
		GridPane.setConstraints(midPanel6, 1, 2);
		GridPane.setConstraints(midPanel7, 0, 3);
		GridPane.setConstraints(midPanel8, 1, 3);
		GridPane.setConstraints(midPanel9, 0, 4);
		GridPane.setConstraints(midPanel10, 1, 4);

		//numbuttonをkeyPanelに追加
		keyPanel.getChildren().addAll(midPanel1, midPanel2, midPanel3, midPanel4, midPanel5, midPanel6, midPanel7, midPanel8, midPanel9, midPanel10);

		//ルートペインを生成
		GridPane root = new GridPane();
		GridPane.setConstraints(result, 0, 0);
		GridPane.setConstraints(keyPanel, 0, 1);

		//ルートペインに配置
		root.getChildren().addAll(result, keyPanel);

		//stageにsceneを配置
		stage.setScene(new Scene(root));
		//表示
		stage.show();
	}

	double resultValue;//入力された文字列を数値にしたもの
	double afterresultValue;//入力された文字列を数値にしたもの
	double resultValue1;//＋−にする
	int currentOp;//直近に押された演算子を数値として記憶する。除算を0，乗算を１，減算を２，加算を３とする。
	String ans;


	//クリアボタンのアクション定義
	public void ClearButtonPressed() {
		result.clear();//表示内容を削除
		resultValue = 0.0;
		afterresultValue = 0.0;
		currentOp = 0;
		result.appendText("");
	}
	//数字ボタンのアクション定義
	public void NumButtonPressed0() {
		result.appendText(numbutton[0].getText());
	}
	public void NumButtonPressed1() {
		result.appendText(numbutton[1].getText());
	}
	public void NumButtonPressed2() {
		result.appendText(numbutton[2].getText());
	}
	public void NumButtonPressed3() {
		result.appendText(numbutton[3].getText());
	}
	public void NumButtonPressed4() {
		result.appendText(numbutton[4].getText());
	}
	public void NumButtonPressed5() {
		result.appendText(numbutton[5].getText());
	}
	public void NumButtonPressed6() {
		result.appendText(numbutton[6].getText());
	}
	public void NumButtonPressed7() {
		result.appendText(numbutton[7].getText());
	}
	public void NumButtonPressed8() {
		result.appendText(numbutton[8].getText());
	}
	public void NumButtonPressed9() {
		result.appendText(numbutton[9].getText());
	}
	public void NumButtonPressed10() {
		result.appendText(numbutton[10].getText());
	}
	//「＋/ー」が押された時に起動する
	public void NumButtonPressed11() {
		resultValue1 = (Double.valueOf(result.getText()));//resultの値を数値に変換
		if(resultValue1 <= 0) {//resultValueが負の時絶対値を返す
			resultValue1 = Math.abs(resultValue1);
			ans = String.valueOf(resultValue1);
			result.clear();
			result.appendText(ans);
		}else {//resultValueが正の時，負の値を返す
			resultValue1 = resultValue1 - resultValue1 * 2;
			ans = String.valueOf(resultValue1);
			result.clear();
			result.appendText(ans);
		}
	}

	public void CalcButtonPressed0() {
		currentOp = 0;//0をcurrentOpに代入（除算）
		resultValue = (Double.valueOf(result.getText()));//resultの値を数値に変換
		result.clear();//テキストフィールドをクリアする
	}
	public void CalcButtonPressed1() {
		currentOp = 1;//1をcurrentOpに代入（乗算）
		resultValue = (Double.valueOf(result.getText()));//resultの値を数値に変換
		result.clear();//テキストフィールドをクリアする
	}
	public void CalcButtonPressed2() {
		currentOp = 2;//2をcurrentOpに代入（減算）
		resultValue = (Double.valueOf(result.getText()));//resultの値を数値に変換
		result.clear();//テキストフィールドをクリアする
	}
	public void CalcButtonPressed3() {
		currentOp = 3;//をcurrentOpに代入（加算）
		resultValue = (Double.valueOf(result.getText()));//resultの値を数値に変換
		result.clear();//テキストフィールドをクリアする
	}
	//=が押された時に起動する
	public void CalcButtonPressed4() {
		afterresultValue = (Double.valueOf(result.getText()));//resultの値を数値に変換
		if(currentOp == 0) {
			resultValue = resultValue / afterresultValue;
		}
		if(currentOp == 1) {
			resultValue = resultValue * afterresultValue;
		}
		if(currentOp == 2) {
			resultValue = resultValue - afterresultValue;
		}
		if(currentOp == 3) {
			resultValue = resultValue + afterresultValue;
		}

		ans = String.valueOf(resultValue);
		result.clear();
		result.appendText(ans);
	}

	public static void main(String[] args) {
		launch();

	}

}

