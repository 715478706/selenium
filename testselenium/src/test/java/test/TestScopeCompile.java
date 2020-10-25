package test;

import newpac.PProject;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestScopeCompile {
    //这个注解只能是普通函数不能是main函数，不然不生效
    @Test
    public void aaa(){
        PProject tt = new PProject();
        tt.disp1();
    }

    public static void main(String[] args) throws IOException {//start新开进程，call是当前进程调用外部批处理文件，执行完了后再执行剩下的命令
        Runtime.getRuntime().exec(String.format("cmd /c start D:\\aaa.bat %1$s", "testselenium"));
    }

}
