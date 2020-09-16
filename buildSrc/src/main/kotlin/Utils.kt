import java.io.File


fun copyApk(files: Array<File>, dirToCoppy: File) {
//    logger.warn("files: ${files.map { it.name }}")
    files.forEach { single ->
        if (single.extension == "apk") {
            single.copyTo(File(dirToCoppy, single.name), true)
        }
    }
}