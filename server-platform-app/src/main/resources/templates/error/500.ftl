<#import "../tags.ftl" as tags>
<!DOCTYPE html>
<html>

<@tags.header.show />

<body class="gray-bg">
    <div class="middle-box text-center animated fadeInDown">
        <h1>500</h1>
        <h3 class="font-bold">Internal Server Error</h3>

        <div class="error-desc">
            <p class="text-danger">
                <strong>${exception!}</strong>
            </p>
            <a href="javascript:history.go(-1)" class="btn btn-white">back</a>
        </div>
    </div>
    <!-- Mainly scripts -->
    <script src="/js/jquery-2.1.1.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</body>

</html>
