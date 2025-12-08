package authz

default allow := false

# Admin can do anything
allow if {
	input.role == "admin"
}

# User can post a blog
allow if {
	input.role == "user"
	input.resource == "blog"
	input.action == "post"
}

# User can get published blogs
allow if {
	input.role == "user"
	input.resource == "blog"
	input.action == "get"
	input.published == true
}

# User can get their own blog (published or not)
allow if {
	input.role == "user"
	input.resource == "blog"
	input.action == "get"
	input.owner_id == input.user_id
}

# User can update their own blog
allow if {
	input.role == "user"
	input.resource == "blog"
	input.action == "update"
	input.owner_id == input.user_id
}

# User can delete their own blog
allow if {
	input.role == "user"
	input.resource == "blog"
	input.action == "delete"
	input.owner_id == input.user_id
}

allow if {
	input.role == "anonymous"
	input.resource == "blog"
	input.action == "get"
	input.published == true
}
