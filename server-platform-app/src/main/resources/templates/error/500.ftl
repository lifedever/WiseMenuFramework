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
                <strong>${exception.message}</strong>
            </p>
            <a href="/" class="btn btn-primary m-t">Dashboard</a>
        </div>
    </div>
    <!-- Mainly scripts -->
    <script src="/js/jquery-2.1.1.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</body>

</html>
