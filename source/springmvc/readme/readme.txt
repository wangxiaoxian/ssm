该项目采用maven进行管理，但是如果jar包都从maven的中央仓库下载，很多都下载失败，而且下载非常非常慢，几乎会吧eclipse卡死。
因此可以采用一些镜像maven库，其中oschina的库是比较好的，将这个备用库信息写入serttings.xml，然后放到C:\Users\wangxiaoxian\.m2目录下，即可。