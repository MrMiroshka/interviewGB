angular.module('student', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8888/app/api/v1';

    $scope.loadStudents = function (pageIndex = 1) {
        $http({
            url: contextPath + '/students',
            method: 'GET',
            params: {
                min_age: $scope.filter ? $scope.filter.min_age : null,
                max_age: $scope.filter ? $scope.filter.max_age : null,
                name_student: $scope.filter ? $scope.filter.name_student : null
            }
        }).then(function (response) {
            $scope.StudentsList = response.data.content;
            $scope.viewDiv($scope.StudentsList.length);
        });
    };

    $scope.deleteStudent = function (studentId) {
        $http.delete(contextPath + '/students/' + studentId)
            .then(function (response) {
                $scope.loadStudents();
            })
    }

    $scope.aboutStudent = function (studentId) {
        $http.get(contextPath + '/students/' + studentId)
            .then(function (response) {
                $scope.StudentsList = response.data;
                $scope.viewDiv($scope.StudentsList.length);
            })
        console.log(contextPath + '/students/' + studentId)
    }



    $scope.viewDiv = function (length) {
        if (length > 1) {
            document.getElementById('div_return').hidden = true;
        } else {
            document.getElementById('div_return').hidden = false;
        }
    }


    $scope.returnStudents = function () {
        $scope.loadStudents();
    }




    $scope.createStudentJson = function () {
        $http.post(contextPath + '/students', $scope.newStudentJson)
            .then(function (response) {
                $scope.loadStudents();
            })
    }

    $scope.loadStudents();
});




