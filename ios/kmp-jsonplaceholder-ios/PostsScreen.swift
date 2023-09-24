//
//  PostsScreen.swift
//  kmp-jsonplaceholder-ios
//
//  Created by Nicolas Picon on 24/09/2023.
//

import SwiftUI
import shared

struct PostsScreen: View {
    @StateObject
    var observableModel = ObservablePostListModel()
    
    var body: some View {
        PostsScreenContent(
            loading: observableModel.loading,
            posts: observableModel.posts,
            error: observableModel.error,
            load: { observableModel.load() }
        ).onAppear {
            observableModel.activate()
        }
        .onDisappear {
            observableModel.deactivate()
        }
    }
}

class ObservablePostListModel: ObservableObject {
    @Published
    var loading = false
    
    @Published
    var posts: [Post]?
    
    @Published
    var error: String?
    
    func activate() {
        // TODO
    }
    
    func deactivate() {
        // TODO
    }
    
    func load() {
        loading = true
        
        // NOTE: Current implementation does not cancel the request if the user exit the screen
        koin.jsonPlaceholderApi.getPosts { posts, error in
            // Warning "Publishing changes from background threads is not allowed" on each property
            self.loading = false
            self.posts = posts
            self.error = error?.localizedDescription
        }
    }
}

struct PostsScreenContent: View {
    var loading: Bool
    var posts: [Post]?
    var error: String?
    var load: () -> Void
    
    var body: some View {
        ZStack {
            VStack {
                Text("Posts")
                if let posts = posts {
                    List(posts, id: \.id) { post in
                        PostRowView(post: post)
                    }
                }
                if let error = error {
                    Text(error)
                        .foregroundColor(.red)
                }
                if loading {
                    Text("Loading...")
                }
                Spacer()
                Button("Load") {
                    load()
                }
            }
        }
    }
}

struct PostRowView: View {
    var post: Post
    var body: some View {
        VStack {
            Text(post.title)
                .bold()
            Text(post.body)
        }
    }
}

struct PostsScreenContent_Previews: PreviewProvider {
    static var previews: some View {
        PostsScreenContent(
            loading: true,
            posts: [/*
                Post(
                    id: 1,
                    userId: 1,
                    title: "Lorem Ipsum",
                    body: "The fox jumps over the fence"
                ),
                Post(
                    id: 2,
                    userId: 1,
                    title: "Something something",
                    body: "Hello from the other side"
                ),*/
            ],
            load: {}
        )
    }
}
