<#import "../tags.ftl" as tags>
<!DOCTYPE html>
<html>
<@tags.header.show />
<body class="gray-bg">
<div class="middle-box text-center animated fadeInDown">
    <h1>401</h1>
    <h3 class="font-bold">UNAUTHORIZED</h3>

    <div class="error-desc">
        <p class="text-danger">
        ${exception.message}
        </p>
        <br>
        <a href="/" class="btn btn-primary">Dashboard</a>
    </div>
</div>
<!-- Mainly scripts -->
<script src="/js/jquery-2.1.1.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
