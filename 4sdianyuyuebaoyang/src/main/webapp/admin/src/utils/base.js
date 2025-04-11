const base = {
    get() {
        return {
            url : "http://localhost:8080/4sdianyuyuebaoyang/",
            name: "4sdianyuyuebaoyang",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/4sdianyuyuebaoyang/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "4S店预约保养系统"
        } 
    }
}
export default base
