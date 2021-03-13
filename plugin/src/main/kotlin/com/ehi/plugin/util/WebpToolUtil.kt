package com.ehi.plugin.util

import com.ehi.plugin.bean.WebpToolBean

/**
 * Created by Omooo
 * Date: 2020-02-13
 * Desc:
 */
class WebpToolUtil {

    companion object {
        val TAG=WebpToolUtil::class.java.simpleName+": "

        fun cmd(cmd: String, params: String) {
            val system = System.getProperty("os.name")

            var cmdStr="${WebpToolBean.getToolsDirPath()}\\windows\\cwebp.exe $params";
            if(system.contains("Windows")){
                cmdStr="${WebpToolBean.getToolsDirPath()}\\windows\\cwebp.exe $params";
            }else if(system.contains("Mac OS X")){
                cmdStr="${WebpToolBean.getToolsDirPath()}/mac/$cmd $params";
            }

            if (cmd == "") {
                println("Cwebp can't support this system.")
                return
            }
            println(TAG+"##cmd##cmdStr=${cmdStr},system=${system}");
            outputMessage(cmdStr)
        }

        private fun outputMessage(cmdStr: String) {
            val process = Runtime.getRuntime().exec(cmdStr)
            process.waitFor()
        }

    }
}