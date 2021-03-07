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
            val cmdStr = when (system) {
                "Windows" ->
                    "${WebpToolBean.getToolsDirPath()}\\windows\\cwebp.exe $params"
                "Mac OS X" ->
                    "${WebpToolBean.getToolsDirPath()}/mac/$cmd $params"
                else -> "${WebpToolBean.getToolsDirPath()}\\windows\\cwebp.exe $params"
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