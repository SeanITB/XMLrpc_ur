package org.example.Models


private val POSITION_KEYS = listOf("x", "y", "z", "rx", "ry", "rz")


class KotlinServer {


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

}