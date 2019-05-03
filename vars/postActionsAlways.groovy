def call() {
    
    /* Use slackNotifier.groovy from shared library and provide current build result as parameter */   
    slackNotifier(currentBuild.currentResult)

}
