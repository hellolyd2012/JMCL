package cn.lyd.jmcl;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import cn.lyd.jmcl.Lib.LaunchGame;
import org.to2mbn.jmccc.launch.LaunchException;

import java.io.IOException;

public class LauncherController {
    @FXML
    private Label StartGame;
    private Label DownLoadGame;
    @FXML
    protected void StartGame() throws IOException,LaunchException {
        LaunchGame.LaunchGame("1.11.2","Notch",".minecraft",900,500,2048,1024);
    }
    @FXML
    protected void GameVersion(){

    }
    @FXML
    protected void DownLoadGame(){
        //消息提示
        Alert DownloadGameM = new Alert(AlertType.INFORMATION);
        DownloadGameM.setTitle("提示");
        DownloadGameM.setHeaderText("下载功能还在开发中!");
        DownloadGameM.showAndWait();
    }
    @FXML
    protected void setting(){
        //消息提示
        Alert DownloadGameM = new Alert(AlertType.INFORMATION);
        DownloadGameM.setTitle("设置提示");
        DownloadGameM.setHeaderText("设置功能还在开发中!");
        DownloadGameM.showAndWait();
    }
}