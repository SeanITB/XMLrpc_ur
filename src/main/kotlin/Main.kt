package org.example

import org.apache.xmlrpc.server.PropertyHandlerMapping
import org.apache.xmlrpc.server.XmlRpcServer
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl
import org.apache.xmlrpc.webserver.WebServer
import org.example.Models.KotlinServer


private val POSITION_KEYS = listOf("x", "y", "z", "rx", "ry", "rz")

fun main() {
    try {
        // Creating the server
        println("Attempting to start XML-RPC Server...")
        val port = 30001
        val webServer: WebServer = WebServer(port)

        // Adding the handler
        val phm: PropertyHandlerMapping = PropertyHandlerMapping()
        phm.addHandler("MyServer", KotlinServer::class.java)

        // Convert it in a xml rpc server
        val xmlRpcServer: XmlRpcServer = webServer.getXmlRpcServer()
        xmlRpcServer.setHandlerMapping(phm)

        // Adding configuration to work
        val serverConfig: XmlRpcServerConfigImpl = (xmlRpcServer.config as XmlRpcServerConfigImpl)
        serverConfig.setEnabledForExtensions(true)
        serverConfig.setContentLengthOptional(false)

        webServer.start()

        println("Started successfully.")
    } catch (e: Exception) {
        println(e.message)
    }
}

fun listToPose(list: List<String>): Map<String, String> {
    val pose = mutableMapOf<String, String>()
    var index = 0
    for (key in POSITION_KEYS) {
        pose.put(key, list[index])
        index++
    }
    return pose.toMap()
}

fun poseToList(dictionary: Map<String, String>): List<String> {
    val list = mutableListOf<String>()
    for (key in POSITION_KEYS) {
        list.add(dictionary[key]!!)
    }
    return list
}

fun randomPose(): Map<String, String> {
    return listToPose(listOf("0.141", "-0.382", "0.277", "1.537", "2.931", "-0.252"))
}