def call() {

    //build job: 'test-registry', propagate: false, wait: false, parameters: [[$class: 'StringParameterValue', name: 'dockerImage', value: "${env.dockerImage}"]]
    script {
        if ("${env.projectBranch}" == 'testakis') {
            build job: 'test-trigger', propagate: false, wait: false, parameters: [[$class: 'StringParameterValue', name: 'projectArtifacts', value: "${env.JOB_NAME}"]]
        }
    }
}