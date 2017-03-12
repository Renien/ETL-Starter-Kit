environments {
    dev {
        azkaban {
            artifacts_dir = "/etl/azkaban/artifacts"
            extClassDir = "$artifacts_dir"
        }
    }

    prod {
        azkaban {
            artifacts_dir = "/etl/azkaban/artifacts"
            extClassDir = "$artifacts_dir"
        }
    }
}