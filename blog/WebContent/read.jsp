<%@page contentType="text/html; charset=Windows-31J"%>
<%@page import="blog.Topic,java.util.List"%>
<html>
<body>

<h2>シンプルBlog</h2>

<a href="read">リロード</a>

<form action="post" method="POST">
	タイトル<input type="text" name="title" size="40">
	<br>
	<textarea name="content" rows="5" cols="40"></textarea>
	<br>
	<input type="submit" value="投稿">
</form>

<%
Object topics = request.getAttribute("topics");
if (topics != null && topics instanceof List){
	for (int i = ((List<?>)topics).size() - 1; i>=0; i--){
		Topic topic = (Topic)((List<?>)topics).get(i);
%>
		<hr>
		タイトル　<%=topic.getTitle()%>
		(<%=topic.getPostDate()%>)
		<pre><%=topic.getContent()%></pre>
<%
	}
}
%>

</body>
</html>